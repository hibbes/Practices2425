/**
 * <b>Galtonbrett</b> (Plinko-Brett) – klassisches Anschauungsmodell für
 * die <b>Binomial­verteilung</b> und deren Annäherung an die Normal­verteilung.
 *
 * <p>Ein Galtonbrett besteht aus mehreren Reihen versetzt angeordneter
 * „Nägel" ({@link Hindernis}). Eine Kugel fällt oben ein und trifft in jeder
 * Reihe auf einen Nagel, der sie zufällig nach links oder rechts ablenkt.
 * Unten werden die Kugeln in Behältern ({@link Behaelter}) gesammelt.
 * Nach vielen Kugeln zeichnet sich im Muster der Füllstände die typische
 * Glockenkurve ab:</p>
 *
 * <pre>
 *               •
 *              / \
 *             •   •
 *            / \ / \
 *           •   •   •
 *          / \ / \ / \
 *         B0  B1  B2  B3     ← Behälter (Endpunkte)
 * </pre>
 *
 * <p>Bei 3 Reihen Hindernissen ergibt sich theoretisch die Verteilung
 * 1 : 3 : 3 : 1 (Pascalsches Dreieck, Zeile 3). Der äußerste Behälter
 * bekommt also ungefähr 1/8 aller Kugeln, die mittleren Behälter je 3/8.</p>
 *
 * <h2>Objektstruktur &amp; Entwurfs­prinzip</h2>
 * <p>Der Baum aus Knoten wird <b>von unten nach oben</b> aufgebaut:
 * zuerst werden die Behälter erzeugt, dann die unterste Reihe Hindernisse
 * (die auf die Behälter zeigen), darüber die nächste Reihe, und so weiter
 * bis zur Spitze. Die Spitze wird in {@link #start} gespeichert.</p>
 *
 * <p>Weil {@link Hindernis} und {@link Behaelter} beide {@link Knoten}
 * implementieren, kann das Galtonbrett denselben Code
 * ({@code k = k.verarbeite()}) für jeden Knoten­typ verwenden – ein
 * klassisches Beispiel für <b>Polymorphismus</b>.</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Interface als gemeinsame Schnittstelle mehrerer Klassen</li>
 *   <li>Polymorphismus: ein Zeigertyp ({@code Knoten}) wird zur Laufzeit
 *       mit verschiedenen konkreten Objekten belegt</li>
 *   <li>Zufallszahlen und Wahrscheinlichkeits­verteilungen</li>
 *   <li>Pascalsches Dreieck → Binomialverteilung → Normalverteilung</li>
 *   <li>Aufbau einer Baum-Struktur aus Objekten</li>
 * </ul>
 *
 * @see Knoten
 * @see Hindernis
 * @see Behaelter
 */
public class Galtonbrett {

    /** Einstiegsknoten – die Spitze des Baums, wo jede Kugel startet. */
    private final Knoten start;

    /** Die Auffangbehälter am unteren Rand (in der Reihenfolge links → rechts). */
    private final Behaelter[] behaelter;

    /**
     * Baut ein Galtonbrett mit drei Reihen Hindernissen und vier Behältern auf.
     *
     * <p>Die zentrale Idee: Hindernisse der mittleren und oberen Reihe
     * zeigen <b>beide</b> auf denselben linken bzw. rechten Nachbarn in
     * der darunter­liegenden Reihe. Dadurch „teilen" sich Kugeln die
     * mittleren Pfade mehrfach – genau das erzeugt die 1 : 3 : 3 : 1
     * Verteilung.</p>
     */
    public Galtonbrett() {
        // Auffangbehälter (Endpunkte)
        behaelter = new Behaelter[] {
            new Behaelter(), new Behaelter(), new Behaelter(), new Behaelter()
        };

        // Unterste Reihe Hindernisse – zeigen direkt auf die Behälter
        Hindernis h4 = new Hindernis(behaelter[0], behaelter[1]);
        Hindernis h5 = new Hindernis(behaelter[1], behaelter[2]);
        Hindernis h6 = new Hindernis(behaelter[2], behaelter[3]);

        // Mittlere Reihe – zeigt auf die untere Reihe (h5 wird doppelt genutzt!)
        Hindernis h2 = new Hindernis(h4, h5);
        Hindernis h3 = new Hindernis(h5, h6);

        // Spitze des Baums – zeigt auf die mittlere Reihe
        start = new Hindernis(h2, h3);
    }

    /**
     * Lässt {@code kugeln} Kugeln durch das Brett fallen.
     *
     * <p>Jede Kugel startet an {@link #start} und wandert durch den Baum,
     * bis {@link Knoten#verarbeite()} den Wert {@code null} zurückgibt
     * (sie ist in einem Behälter angekommen).</p>
     *
     * @param kugeln Anzahl der zu simulierenden Kugeln
     */
    public void simuliere(int kugeln) {
        for (int i = 0; i < kugeln; i++) {
            Knoten k = start;
            while (k != null) {
                k = k.verarbeite();
            }
        }
    }

    /**
     * Gibt die aktuelle Verteilung als einfaches ASCII-Säulendiagramm aus.
     *
     * <p>Jeder {@code #}-Block steht für etwa 1 % der Gesamtkugeln –
     * so bleibt die Ausgabe auch bei großen Zahlen übersichtlich.</p>
     */
    public void zeigeVerteilung() {
        int gesamt = 0;
        for (Behaelter b : behaelter) {
            gesamt += b.getAnzahl();
        }
        System.out.println("Verteilung nach " + gesamt + " Kugeln:");
        for (int i = 0; i < behaelter.length; i++) {
            int n = behaelter[i].getAnzahl();
            int prozent = (gesamt == 0) ? 0 : (100 * n) / gesamt;
            StringBuilder bar = new StringBuilder();
            for (int j = 0; j < prozent; j++) {
                bar.append('#');
            }
            System.out.printf("  B%d [%5d  %3d%%] %s%n", i, n, prozent, bar.toString());
        }
    }

    /**
     * Demo: 10 000 Kugeln durch das Brett fallen lassen und die Verteilung
     * ausgeben. Erwartet wird näherungsweise 1 : 3 : 3 : 1 (also etwa
     * 12,5 % / 37,5 % / 37,5 % / 12,5 %).
     */
    public static void main(String[] args) {
        Galtonbrett g = new Galtonbrett();
        g.simuliere(10_000);
        g.zeigeVerteilung();
    }
}

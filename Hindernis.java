/**
 * Ein Entscheidungs­knoten im {@link Galtonbrett Galtonbrett} – ein „Nagel",
 * der eine ankommende Kugel mit gleicher Wahrscheinlichkeit nach links oder
 * nach rechts weiterleitet.
 *
 * <p>Ein Hindernis kennt zwei Nachfolger: einen linken und einen rechten.
 * Beide sind wieder vom Typ {@link Knoten} – das können entweder weitere
 * {@link Hindernis}-Objekte sein (tiefer im Baum) oder {@link Behaelter}
 * (am Rand). Dadurch lässt sich der gesamte Baum einheitlich aufbauen,
 * ohne Sonderfälle im Code.</p>
 *
 * <p><b>Randomisierung:</b> {@link Math#random()} liefert einen {@code double}
 * im Intervall [0.0, 1.0). Durch den Vergleich mit 0.5 bekommen wir exakt
 * eine 50/50-Entscheidung. Das entspricht einer fairen Münze – und genau
 * dieser Zufallsschritt erzeugt nach mehreren Ebenen die bekannte
 * <b>Binomialverteilung</b> (näherungsweise Normalverteilung).</p>
 *
 * @see Knoten
 * @see Behaelter
 */
public class Hindernis implements Knoten {

    /** Nachfolger, wenn die Kugel nach links fällt. */
    private final Knoten links;

    /** Nachfolger, wenn die Kugel nach rechts fällt. */
    private final Knoten rechts;

    /**
     * Erzeugt ein neues Hindernis mit festen Nachfolgern.
     *
     * @param links  Knoten, zu dem bei einer Links-Entscheidung weitergeleitet wird
     * @param rechts Knoten, zu dem bei einer Rechts-Entscheidung weitergeleitet wird
     */
    public Hindernis(Knoten links, Knoten rechts) {
        this.links  = links;
        this.rechts = rechts;
    }

    /**
     * Würfelt eine faire Münze: mit Wahrscheinlichkeit 0,5 wird die Kugel
     * nach links geschickt, sonst nach rechts.
     */
    @Override
    public Knoten verarbeite() {
        if (Math.random() < 0.5) {
            return links;
        }
        return rechts;
    }
}

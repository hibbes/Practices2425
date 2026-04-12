/**
 * Gemeinsame Schnittstelle für alle Knoten eines {@link Galtonbrett Galtonbretts}.
 *
 * <p>Ein Knoten ist eine Station im Baum, durch die eine Kugel wandert. Jede
 * Station gibt über {@link #verarbeite()} den <b>nächsten</b> Knoten zurück
 * – oder {@code null}, wenn die Kugel ihr Ziel erreicht hat.</p>
 *
 * <p>Die beiden konkreten Umsetzungen sind:
 * <ul>
 *   <li>{@link Hindernis} – Entscheidungsknoten, schickt die Kugel zufällig
 *       nach links oder rechts weiter</li>
 *   <li>{@link Behaelter} – Endpunkt, zählt die ankommenden Kugeln und gibt
 *       {@code null} zurück</li>
 * </ul>
 *
 * <p><b>Lernziel:</b> Polymorphismus – das Galtonbrett ruft auf jedem Knoten
 * nur {@code verarbeite()} auf, ohne zu wissen, <i>welche</i> konkrete Sorte
 * Knoten dahinter steckt. Hindernis und Behaelter verhalten sich darunter
 * völlig unterschiedlich, aber der Aufrufer muss das nicht wissen.</p>
 */
public interface Knoten {

    /**
     * Verarbeitet den Durchgang einer Kugel durch diesen Knoten.
     *
     * @return der nächste zu besuchende Knoten, oder {@code null}, wenn
     *         die Kugel ihr Ziel erreicht hat
     */
    Knoten verarbeite();
}

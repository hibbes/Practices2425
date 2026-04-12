/**
 * Endpunkt (Auffangbehälter) am unteren Ende eines {@link Galtonbrett Galtonbretts}.
 *
 * <p>Ein Behälter zählt lediglich, wie viele Kugeln bei ihm angekommen sind.
 * Seine {@link #verarbeite()}-Methode liefert {@code null} zurück – das
 * signalisiert dem Galtonbrett, dass die Kugel ihren Weg beendet hat.</p>
 *
 * @see Knoten
 * @see Hindernis
 */
public class Behaelter implements Knoten {

    /** Anzahl der bisher eingefangenen Kugeln. */
    private int anzahl = 0;

    /**
     * Eine Kugel erreicht diesen Behälter: den Zähler erhöhen und
     * {@code null} als „kein nächster Knoten" zurückgeben.
     */
    @Override
    public Knoten verarbeite() {
        anzahl++;
        return null;
    }

    /** @return Anzahl der Kugeln, die bisher in diesem Behälter gelandet sind */
    public int getAnzahl() {
        return anzahl;
    }
}

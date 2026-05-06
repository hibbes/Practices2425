/**
 * Schienenfahrzeug als Erweiterung der {@link Fahrzeug}-Hierarchie.
 *
 * <p>Demonstriert, dass von einer abstrakten Basisklasse beliebig viele
 * Spezialisierungen abgeleitet werden können. {@link Auto} und
 * {@link Fahrrad} sind Straßenfahrzeuge, {@link Zug} fährt auf Schienen –
 * alle drei sind durch ihre gemeinsame Schnittstelle {@link Fahrzeug}
 * austauschbar (Polymorphismus).</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Vererbung: konkrete Implementierung einer abstrakten Klasse</li>
 *   <li>Methoden-Override: {@link #fahren()} und {@link #anzahlRaeder()}</li>
 *   <li>{@code super(...)}-Aufruf im Konstruktor</li>
 * </ul>
 *
 * @see Fahrzeug
 * @see Auto
 * @see Fahrrad
 */
public class Zug extends Fahrzeug {

    /**
     * Erzeugt einen neuen Zug.
     *
     * @param name             Anzeigename des Zuges
     * @param geschwindigkeit  Höchstgeschwindigkeit in km/h
     */
    public Zug(String name, int geschwindigkeit) {
        super(name, geschwindigkeit);
    }

    /** Ein Zug bewegt sich auf Schienen, nicht auf der Straße. */
    @Override
    public void fahren() {
        System.out.println("Der Zug fährt auf den Schienen");
    }

    /** Ein Zug hat keine feste Räderzahl – Lokomotive, Wagen und Drehgestelle variieren. */
    @Override
    public void anzahlRaeder() {
        System.out.println("Der Zug hat viele Räder");
    }
}

import java.time.LocalDateTime;

/**
 * Basisklasse eines Datei­system-Eintrags – kann eine Datei oder
 * (über die Unterklasse {@link Verzeichnis}) ein Ordner sein.
 *
 * <p>Jeder Eintrag kennt sein <b>Eltern­verzeichnis</b>, hat einen Namen,
 * ein Änderungs­datum und eine Lösch-Erlaubnis. Beim Erzeugen meldet sich
 * der Eintrag selbsttätig im Eltern­verzeichnis an – so bleibt die
 * Eltern-Kind-Beziehung konsistent.</p>
 *
 * <h2>Klassendiagramm</h2>
 * <pre>
 *                Eintrag
 *               /       \
 *           Datei*    Verzeichnis
 *                       (eintraege[])
 * </pre>
 * <p>(*)&nbsp;Konkrete Datei-Klassen werden hier nicht modelliert –
 * jeder direkte {@code Eintrag} ohne {@code Verzeichnis}-Spezialisierung
 * ist im einfachsten Fall „eine Datei".</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Vererbung mit Selbst­referenz ({@link Verzeichnis} hält {@code Eintrag[]},
 *       ist aber selbst Eintrag → klassische Composite-Struktur)</li>
 *   <li>Konstruktor-Logik: Selbst­anmeldung im Eltern-Objekt</li>
 *   <li>Setter mit Vor­bedingungen (Umbenennen nur unter Eltern-Kontext)</li>
 *   <li>Datums-Verwaltung mit {@link LocalDateTime}</li>
 * </ul>
 *
 * @see Verzeichnis
 */
public class Eintrag {
    protected String name;
    protected Verzeichnis elternVerz;
    protected LocalDateTime aenderungsDatum;
    protected boolean loeschbar;

    /**
     * Erzeugt einen neuen Eintrag und meldet ihn (sofern angegeben) im
     * Eltern­verzeichnis an.
     *
     * @param name        Anzeige­name des Eintrags
     * @param elternVerz  Eltern­verzeichnis oder {@code null} für die Wurzel
     */
    public Eintrag(String name, Verzeichnis elternVerz) {
        this.name = name;
        this.elternVerz = elternVerz;
        this.aenderungsDatum = getSystemzeit();
        this.loeschbar = true;

        if (elternVerz != null) {
            elternVerz.einfuegen(this);
        }
    }

    /** Aktuelle Systemzeit – bewusst als Methode, damit Tests sie überschreiben könnten. */
    protected LocalDateTime getSystemzeit() {
        return LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public Verzeichnis getElternVerz() {
        return elternVerz;
    }

    public LocalDateTime getAenderungsDatum() {
        return aenderungsDatum;
    }

    public boolean isLoeschbar() {
        return loeschbar;
    }

    public void setLoeschbar(boolean loeschbar) {
        this.loeschbar = loeschbar;
    }

    /**
     * Benennt den Eintrag um, sofern der neue Name eindeutig zum bisherigen
     * Namen abweicht und ein Eltern­verzeichnis existiert.
     *
     * @param neuerName der gewünschte neue Name
     * @return {@code true}, wenn umbenannt wurde, sonst {@code false}
     */
    public boolean umbenennen(String neuerName) {
        if (neuerName == null || this.name.equals(neuerName) || elternVerz == null) {
            return false;
        }
        this.name = neuerName;
        this.aenderungsDatum = getSystemzeit();
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}

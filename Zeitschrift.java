/**
 * Zeitschrift – konkretes {@link Medium} mit zwei­stufiger Tarifik.
 *
 * <p>Aktuelle Ausgaben (Heft des laufenden Monats) sind teurer und
 * dürfen nur kurz mitgenommen werden. Ältere Ausgaben sind günstiger
 * und länger ausleihbar.</p>
 */
public class Zeitschrift extends Medium {

    /** Ausleih­dauer in Tagen für aktuelle Hefte. */
    public static final int MAX_DAUER_AKTUELL = 1;

    /** Ausleih­dauer in Tagen für ältere Hefte. */
    public static final int MAX_DAUER_ARCHIV = 14;

    /** Tagessatz für aktuelle Hefte. */
    public static final double GEBUEHR_AKTUELL = 1.00;

    /** Tagessatz für ältere Hefte (gratis innerhalb der Frist). */
    public static final double GEBUEHR_UEBERZIEHEN_ARCHIV = 0.10;

    private final String ausgabe;
    private final boolean aktuelleAusgabe;

    public Zeitschrift(String titel, String id, String ausgabe, boolean aktuelleAusgabe) {
        super(titel, id);
        this.ausgabe = ausgabe;
        this.aktuelleAusgabe = aktuelleAusgabe;
    }

    public String getAusgabe() {
        return ausgabe;
    }

    public boolean istAktuelleAusgabe() {
        return aktuelleAusgabe;
    }

    @Override
    public double berechneGebuehr() {
        long tage = ausgelieheneTage();
        if (aktuelleAusgabe) {
            long abrechnungstage = Math.max(1, tage);
            return abrechnungstage * GEBUEHR_AKTUELL;
        }
        long ueberzogen = tage - MAX_DAUER_ARCHIV;
        if (ueberzogen <= 0) return 0.0;
        return ueberzogen * GEBUEHR_UEBERZIEHEN_ARCHIV;
    }

    @Override
    public int getMaxAusleihdauer() {
        return aktuelleAusgabe ? MAX_DAUER_AKTUELL : MAX_DAUER_ARCHIV;
    }

    @Override
    public String toString() {
        return super.toString() + " — Zeitschrift " + ausgabe
            + (aktuelleAusgabe ? " (aktuell)" : " (Archiv)");
    }
}

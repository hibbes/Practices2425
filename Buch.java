/**
 * Buch – konkretes {@link Medium} mit klassischer Bibliotheks-Tarifik.
 *
 * <p>Innerhalb der Frist gratis, danach 0,20&nbsp;€ pro über­zogenem Tag.
 * Das spiegelt typische öffentliche Stadt­büchereien wider.</p>
 */
public class Buch extends Medium {

    /** Maximale Ausleih­dauer in Tagen. */
    public static final int MAX_DAUER_TAGE = 28;

    /** Mahn­gebühr pro Tag, der über die Frist hinaus geht. */
    public static final double GEBUEHR_PRO_UEBERZOGENEM_TAG = 0.20;

    private final String autor;
    private final int seitenzahl;

    public Buch(String titel, String id, String autor, int seitenzahl) {
        super(titel, id);
        this.autor = autor;
        this.seitenzahl = seitenzahl;
    }

    public String getAutor() {
        return autor;
    }

    public int getSeitenzahl() {
        return seitenzahl;
    }

    @Override
    public double berechneGebuehr() {
        long tage = ausgelieheneTage();
        long ueberzogen = tage - MAX_DAUER_TAGE;
        if (ueberzogen <= 0) return 0.0;
        return ueberzogen * GEBUEHR_PRO_UEBERZOGENEM_TAG;
    }

    @Override
    public int getMaxAusleihdauer() {
        return MAX_DAUER_TAGE;
    }

    @Override
    public String toString() {
        return super.toString() + " — Buch von " + autor + " (" + seitenzahl + " S.)";
    }
}

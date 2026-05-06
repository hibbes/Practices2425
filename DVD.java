/**
 * DVD – konkretes {@link Medium} mit kommerzieller Ausleih-Tarifik.
 *
 * <p>1,00&nbsp;€ pro Tag ab dem ersten Tag, maximal 7 Tage Ausleihe.
 * Damit kostet auch eine eintägige Ausleihe Geld – anders als beim
 * {@link Buch}, das innerhalb der Frist gratis ist.</p>
 */
public class DVD extends Medium {

    /** Maximale Ausleih­dauer in Tagen. */
    public static final int MAX_DAUER_TAGE = 7;

    /** Tarif pro Ausleih-Tag. */
    public static final double GEBUEHR_PRO_TAG = 1.00;

    private final String regisseur;
    private final int laufzeitMinuten;

    public DVD(String titel, String id, String regisseur, int laufzeitMinuten) {
        super(titel, id);
        this.regisseur = regisseur;
        this.laufzeitMinuten = laufzeitMinuten;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public int getLaufzeitMinuten() {
        return laufzeitMinuten;
    }

    @Override
    public double berechneGebuehr() {
        long tage = ausgelieheneTage();
        // Mindestens 1 Tag berechnen, sobald ausgeliehen wurde
        long abrechnungstage = Math.max(1, tage);
        return abrechnungstage * GEBUEHR_PRO_TAG;
    }

    @Override
    public int getMaxAusleihdauer() {
        return MAX_DAUER_TAGE;
    }

    @Override
    public String toString() {
        return super.toString() + " — DVD von " + regisseur + " (" + laufzeitMinuten + " min)";
    }
}

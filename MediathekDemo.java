/**
 * Demo-Programm für die Medien­verwaltung ({@link Medium}, {@link Buch},
 * {@link DVD}, {@link Zeitschrift}).
 *
 * <p>Zeigt:</p>
 * <ul>
 *   <li>Polymorphismus über das gemeinsame {@code Medium[]}</li>
 *   <li>Ausleihen / Zurückgeben / Gebühren­berechnung</li>
 *   <li>Unterschiedliche Tarifik je Medien­typ</li>
 * </ul>
 *
 * <p>Hinweis: Die Gebühren werden auf Basis von {@code LocalDate.now()}
 * gegen das Ausleih­datum gerechnet. In dieser Demo ist die Differenz
 * 0 Tage – DVD und aktuelle Zeitschrift erheben den Mindest-Tagessatz,
 * Buch und Archiv-Zeitschrift sind innerhalb der Frist gratis.</p>
 */
public class MediathekDemo {

    public static void main(String[] args) {
        Medium[] regal = {
            new Buch("Effective Java", "B-001", "Joshua Bloch", 416),
            new DVD("Inception", "D-042", "Christopher Nolan", 148),
            new Zeitschrift("c't", "Z-2025-12", "12/2025", true),
            new Zeitschrift("c't", "Z-2024-03", "03/2024", false),
        };

        System.out.println("=== Medien­bestand ===");
        for (Medium m : regal) {
            System.out.println("  " + m);
        }

        System.out.println();
        System.out.println("=== Alle ausleihen ===");
        for (Medium m : regal) {
            m.ausleihen();
            System.out.println("  ausgeliehen: " + m);
        }

        System.out.println();
        System.out.println("=== Alle zurückgeben ===");
        double gesamt = 0;
        for (Medium m : regal) {
            double gebuehr = m.zurueckgeben();
            gesamt += gebuehr;
            System.out.printf("  zurück: %-30s  Gebühr: %.2f €%n", m.getTitel(), gebuehr);
        }
        System.out.printf("Gesamt­einnahme: %.2f €%n", gesamt);

        // Doppel-Ausleihen-Check: ein bereits verliehenes Medium nochmal ausleihen
        System.out.println();
        System.out.println("=== Doppel-Ausleihe-Check ===");
        Medium m = regal[0];
        m.ausleihen();
        boolean verfuegbar = m.istVerfuegbar();
        m.ausleihen(); // sollte nichts ändern
        System.out.println("  " + m.getTitel() + " verfügbar nach 1. Ausleihe? " + verfuegbar);
        System.out.println("  " + m.getTitel() + " 2. ausleihen ändert nichts: ausleihdatum bleibt " + m.getAusleihdatum());
        m.zurueckgeben();
    }
}

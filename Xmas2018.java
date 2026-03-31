import java.util.Random;

/**
 * Zeichnet einen ASCII-Weihnachtsbaum in der Konsole – mit zufällig platzierten
 * Christbaumkugeln (@) und Tannennadeln (X).
 *
 * <p><b>Aufgabe aus dem Unterricht (Weihnachten 2018)</b></p>
 *
 * <h2>Algorithmus-Idee</h2>
 * <p>Der Baum wird von oben nach unten Zeile für Zeile gedruckt.
 * Pro Zeile gilt:
 * <ul>
 *   <li>Zuerst werden Leerzeichen gedruckt (für die dreieckige Form)</li>
 *   <li>Dann werden Blätter (X oder @) gedruckt – pro Zeile mehr als in der vorherigen</li>
 *   <li>Am Ende wird der Stamm gedruckt (2 oder 3 senkrechte Striche)</li>
 * </ul>
 * </p>
 *
 * <p><b>Lernziele:</b>
 * <ul>
 *   <li>Verschachtelte Schleifen: äußere Schleife (Zeilen) + innere Schleifen (Zeichen)</li>
 *   <li>Zufallszahlen: Modulo-Trick ({@code zufallszahl % 7 == 0}) für seltene Ereignisse</li>
 *   <li>Variablen als Zustand über Schleifendurchläufe hinweg</li>
 * </ul>
 * </p>
 *
 * @author hibbes (Weihnachten 2018)
 */
public class Xmas2018 {

    /**
     * Zeichnet den Weihnachtsbaum Zeile für Zeile auf der Konsole.
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {

        int breite = 100;  // Gesamtbreite des Baums (dickste Stelle)
        int count  = 1;    // Anzahl der Blätter in der aktuellen Zeile (steigt mit jeder Zeile)
        int stamm  = breite; // Merker für die Stammbreite (= ursprüngliche Gesamtbreite)

        Random random = new Random();
        int zufallszahl;

        // ── Baumkrone: eine Zeile pro while-Durchlauf ────────────────────────
        // breite verringert sich um 1 pro Zeile (Baum wird nach oben schmaler)
        while (breite > 0) {

            // Leerzeichen drucken: Anzahl = halbe aktuelle Breite (zentriert den Baum)
            for (int i = 0; i < breite / 2; i++) {
                System.out.print(" ");
            }
            breite--;  // eine Leerzeichen-Einheit weniger in der nächsten Zeile

            // Blätter drucken: count Zeichen, zufällig X (Nadel) oder @ (Kugel)
            for (int i = 0; i < count; i++) {
                zufallszahl = 1 + random.nextInt(7); // Zufallszahl 1–7
                if (zufallszahl % 7 == 0) {
                    // mit ~14% Wahrscheinlichkeit: Christbaumkugel
                    System.out.print("@");
                } else {
                    // sonst: Tannennadel
                    System.out.print("X");
                }
            }
            System.out.println();  // Zeilenumbruch
            count++;               // nächste Zeile hat ein Blatt mehr
        }

        // ── Baumstamm ────────────────────────────────────────────────────────
        // Einrücken: halb so viele Leerzeichen wie der Stamm breit ist
        for (int i = 0; i < (count / 2) - 1; i++) {
            System.out.print(" ");
        }

        // Stammbreite: 2 Striche wenn count gerade, 3 wenn ungerade
        int stammBreite = (count % 2 == 0) ? 2 : 3;
        for (int i = 0; i < stammBreite; i++) {
            System.out.print("|");
        }
    }
}

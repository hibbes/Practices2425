import java.util.Random;

public class Weihnachtsbaum {

    // Farbcodes für die ANSI Escape-Sequenzen
    private static final String RESET = "\033[0m";
    private static final String GRUEN = "\033[32m"; // Grün für die Blätter
    private static final String BRAUN = "\033[38;5;94m"; // Dunkelgelb (nah an Braun) für den Stamm
    private static final String[] KUGELN_FARBE = {
        "\033[31m", // Rot
        "\033[34m", // Blau
        "\033[35m", // Magenta
        "\033[36m", // Cyan
        "\033[37m"  // Weiß
    };

    public static void main(String[] args) {
        int breite = 21; // Maximalbreite des Baumes
        Random random = new Random(); // Zufallsobjekt

        // Blätter und Kugeln ausgeben
        for (int blaetter = 1; blaetter <= breite; blaetter += 2) {
            // Leerzeichen zum Zentrieren und zufälliges Symbol erzeugen
            String zeile = " ".repeat((breite - blaetter) / 2);

            // Für jedes Blatt entweder ein @ oder X (1 von 7 Fällen für @)
            for (int j = 0; j < blaetter; j++) {
                String symbol;
                String color;

                if (random.nextInt(7) == 0) { // 1 von 7 Fällen für Kugel
                    symbol = "@";
                    color = KUGELN_FARBE[random.nextInt(KUGELN_FARBE.length)]; // Zufällige Kugelfarbe
                } else {
                    symbol = "X";
                    color = GRUEN; // Blätter immer grün
                }

                zeile += color + symbol; // Farbiges Symbol anfügen
            }

            // Zeile ausgeben
            System.out.println(zeile + RESET); // Reset der Farbe nach der Zeile
        }

        // Stamm ausgeben, immer braun (mit dunklem Gelb simuliert)
        System.out.println(BRAUN + " ".repeat((breite - 3) / 2) + "###" + RESET);
    }
}

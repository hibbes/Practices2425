import java.util.*;

public class HanoiStatic {
    // Zählt die Anzahl der durchgeführten Schritte
    static int counter = 0;

    // Drei Stapel (Stacks) zur Simulation der drei Türme A, B, C
    Stack<Integer> turmA = new Stack<>();
    Stack<Integer> turmB = new Stack<>();
    Stack<Integer> turmC = new Stack<>();

    /**
     * Initialisiert die Türme, indem alle Scheiben in absteigender Reihenfolge
     * (größte unten, kleinste oben) auf Turm A gelegt werden.
     */
    public void initTuerme(int scheiben) {
        for (int i = scheiben; i >= 1; i--) {
            turmA.push(i);  // Größte Scheibe zuerst
        }
    }

    /**
     * Führt einen einzelnen Zug von einer Scheibe aus einem Turm auf einen anderen durch.
     * Gibt den Zug aus und zeigt danach den Zustand der Türme.
     */
    public void bewegeScheibe(int von, int nach) {
        Stack<Integer> quelle = getTurm(von);  // Ursprungsstapel
        Stack<Integer> ziel = getTurm(nach);   // Zielstapel

        if (!quelle.isEmpty()) {
            int scheibe = quelle.pop();       // Scheibe vom Ursprung entfernen
            ziel.push(scheibe);               // Scheibe auf Zielturm legen
            counter++;                        // Schrittzähler erhöhen
            System.out.println("Schritt " + counter + ": Bewege Scheibe " + scheibe + " von Turm " + von + " nach Turm " + nach);
            printTuerme();                    // Aktuellen Zustand der Türme ausgeben
        }
    }

    /**
     * Gibt den zu einer Turmnummer (1, 2 oder 3) gehörenden Stack zurück.
     */
    public Stack<Integer> getTurm(int nummer) {
        return switch (nummer) {
            case 1 -> turmA;
            case 2 -> turmB;
            case 3 -> turmC;
            default -> throw new IllegalArgumentException("Ungueltiger Turm: " + nummer);
        };
    }

    /**
     * Rekursive Methode zur Lösung des Türme-von-Hanoi-Problems.
     * Verschiebt n Scheiben von Turm 'von' nach Turm 'nach' unter Verwendung von 'zwischenspeicher'.
     */
    public void bewegeMehrereScheiben(int n, int von, int nach, int zwischenspeicher) {
        if (n == 1) {
            // Basisfall: Nur eine Scheibe bewegen
            bewegeScheibe(von, nach);
        } else {
            // Rekursiver Schritt:
            // 1. Verschiebe n-1 Scheiben vom Ursprung auf Zwischenspeicher
            bewegeMehrereScheiben(n - 1, von, zwischenspeicher, nach);

            // 2. Verschiebe die unterste (größte) Scheibe auf das Ziel
            bewegeScheibe(von, nach);

            // 3. Verschiebe die n-1 Scheiben vom Zwischenspeicher zum Ziel
            bewegeMehrereScheiben(n - 1, zwischenspeicher, nach, von);
        }
    }

    /**
     * Gibt den aktuellen Zustand aller drei Türme (Stacks) in der Konsole aus.
     */
    public void printTuerme() {
        System.out.println("Turm 1: " + turmA);
        System.out.println("Turm 2: " + turmB);
        System.out.println("Turm 3: " + turmC);
        System.out.println("----------------------------");
    }

    /**
     * Hauptmethode zur Programmausführung.
     * Initialisiert das Problem und startet die Lösung mit einer bestimmten Anzahl von Scheiben.
     */
    public static void main(String[] args) {
        HanoiStatic hanoi = new HanoiStatic();
        int scheiben = 3; // Anzahl der Scheiben; kann angepasst werden

        hanoi.initTuerme(scheiben);              // Stapel initial befüllen
        hanoi.printTuerme();                     // Anfangszustand anzeigen
        hanoi.bewegeMehrereScheiben(scheiben, 1, 3, 2); // Rekursive Lösung starten
        System.out.println("Anzahl der Schritte: " + counter); // Gesamte Schrittzahl ausgeben
    }
}

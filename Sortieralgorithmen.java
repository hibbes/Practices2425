import java.util.Random;

/**
 * Sammlung dreier Sortieralgorithmen mit sehr unterschiedlichen Charakteren –
 * vom soliden Klassiker bis zum „nie ernsthaft verwenden, aber lustig":
 *
 * <ul>
 *   <li><b>BubbleSort</b> – einfacher Tausch-Algorithmus, O(n²) Vergleiche</li>
 *   <li><b>GnomeSort</b> – „Gartenzwerg-Sortieren", elegant in der Idee, ebenfalls O(n²)</li>
 *   <li><b>BogoSort</b> – Mischen + Hoffen, Erwartungswert O(n·n!)
 *       (für 10 Elemente bereits ~36 Millionen Versuche)</li>
 * </ul>
 *
 * <p>Jeder Algorithmus zählt seine „Rechenschritte" (Tausch- bzw.
 * Iterationsoperationen) und gibt sie laufend aus, damit das
 * Aufwands­verhalten am Bildschirm sichtbar wird.</p>
 *
 * <h2>Vergleich auf einen Blick</h2>
 * <table>
 *   <caption>Asymptotisches Laufzeitverhalten</caption>
 *   <tr><th>Algorithmus</th><th>Best&nbsp;Case</th><th>Average&nbsp;Case</th><th>Worst&nbsp;Case</th></tr>
 *   <tr><td>BubbleSort</td><td>O(n)</td><td>O(n²)</td><td>O(n²)</td></tr>
 *   <tr><td>GnomeSort</td><td>O(n)</td><td>O(n²)</td><td>O(n²)</td></tr>
 *   <tr><td>BogoSort</td><td>O(n)</td><td>O(n·n!)</td><td>unendlich (theoretisch)</td></tr>
 * </table>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Drei Sortier-Strategien direkt vergleichen</li>
 *   <li>Verstehen, warum Tauschoptimierungen (do/while + swapped-Flag) helfen</li>
 *   <li>Komplexität durch Zählen von Rechenschritten greifbar machen</li>
 *   <li>Hilfsmethoden ({@link #isSorted(int[])}, {@link #shuffle(int[])}) als Bausteine</li>
 * </ul>
 *
 * @see MergeSort  weiter­führend: ein effizienter Algorithmus mit O(n·log&nbsp;n)
 */
public class Sortieralgorithmen {
    public static void main(String[] args) {

        int[] array = {5, 3, 8, 4, 2, 7, 10, 1, 6, 9};
        // Wähle hier den zu testenden Algorithmus aus:
        // bogoSort(array);     // ⚠ extrem langsam – nur für n ≤ 8 sinnvoll
        gnomeSort(array);
        // bubbleSort(array);

        System.out.print("Ergebnis: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Klassisches BubbleSort: benachbarte Elemente werden in jedem Durchgang
     * verglichen und ggf. getauscht. Nach jedem Durchgang ist mindestens das
     * letzte Element auf seinem endgültigen Platz – {@code n--} reduziert
     * die innere Schleife entsprechend.
     */
    public static int[] bubbleSort(int[] array) {
        int rechenschritte = 0;
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                    System.out.println("Rechenschritte: " + (++rechenschritte));
                }
            }
            n--; // Letzte Position ist nach dem Durchgang fertig sortiert
        } while (swapped);
        return array;
    }

    /**
     * GnomeSort: ein Index läuft von links nach rechts; sobald ein Paar
     * verkehrt herum ist, wird getauscht und der Index <i>einen Schritt
     * zurück</i> gesetzt – wie ein Gartenzwerg, der in seiner Reihe von
     * Blumentöpfen zurückläuft, bis alles passt. Konzeptionell schöner
     * als BubbleSort, in der Praxis ähnlich teuer (O(n²)).
     */
    public static int[] gnomeSort(int[] array) {
        int rechenschritte = 0;
        int index = 0;
        while (index < array.length) {
            if (index == 0) {
                index++;
            }
            if (array[index] >= array[index - 1]) {
                index++;
            } else {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
                System.out.println("Rechenschritte: " + (++rechenschritte));
            }
        }
        return array;
    }

    /**
     * BogoSort: das Array wird zufällig gemischt, bis es zufällig sortiert
     * ist. Der Erwartungswert der Versuche ist {@code n!}. Für 10 Elemente
     * also ~3,6 Millionen Versuche – Geduld!
     *
     * <p>Sinn: zeigt eindrücklich, was „schlechte" Komplexität in der Praxis
     * bedeutet. <b>Niemals</b> für reale Daten verwenden.</p>
     */
    public static int[] bogoSort(int[] array) {
        int rechenschritte = 0;
        while (!isSorted(array)) {
            shuffle(array);
            System.out.println("Rechenschritte: " + (++rechenschritte));
        }
        return array;
    }

    /** Liefert {@code true}, wenn das Array bereits aufsteigend sortiert ist. */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /** Fisher-Yates-ähnliches Mischen (in-place) – Hilfsmethode für BogoSort. */
    public static void shuffle(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }
}

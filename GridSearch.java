/**
 * Einfacher Pfad durch ein 2D-Gitter (immer erst nach rechts, dann nach unten).
 *
 * <p>Kein „echter" Suchalgorithmus – die Klasse demonstriert vielmehr den
 * Umgang mit zweidimensionalen Arrays, indem sie einen festen L-förmigen
 * Pfad von der oberen linken Ecke {@code (0,0)} bis zur unteren rechten
 * Ecke {@code (rows-1, cols-1)} markiert:</p>
 *
 * <pre>
 *   1 1 1
 *   . . 1
 *   . . 1
 * </pre>
 *
 * <p>Eine sinnvolle Erweiterung wäre, einen wirklichen kürzesten Pfad
 * zu suchen (z.B. Breiten­suche / BFS) oder das Gitter mit Hindernissen
 * zu versehen, die der Pfad umfahren muss.</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Erstellen und Beschreiben zweidimensionaler {@code int}-Arrays</li>
 *   <li>Schleifen-Logik mit zwei laufenden Indizes</li>
 *   <li>Zähler ({@code right}, {@code down}) zusätzlich zur Zustandsmatrix</li>
 * </ul>
 */
public class GridSearch {
    private int rows;
    private int cols;
    private int[][] grid;

    public GridSearch(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    /**
     * Markiert den L-förmigen Pfad rechts → unten und gibt eine
     * kurze Zusammenfassung auf {@code System.out} aus.
     */
    public void findPath() {
        int right = 0;
        int down = 0;
        int col = 0;
        int row = 0;

        // Startposition markieren
        grid[row][col] = 1;

        // Erst die ganze obere Zeile nach rechts laufen
        while (col < cols - 1) {
            col++;
            right++;
            grid[row][col] = 1;
        }

        // Dann die rechte Spalte nach unten laufen
        while (row < rows - 1) {
            row++;
            down++;
            grid[row][col] = 1;
        }

        System.out.println("Pfad von (0,0) nach (" + (rows - 1) + "," + (cols - 1) + "):");
        System.out.println("Schritte nach rechts: " + right);
        System.out.println("Schritte nach unten: " + down);
        zeigeGitter();
    }

    /** Gibt die aktuelle Belegung des Gitters als kleine Matrix aus. */
    private void zeigeGitter() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(grid[r][c] == 1 ? "1 " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GridSearch gridSearch = new GridSearch(3, 3);
        gridSearch.findPath();
    }
}

/**
 * <b>Java-Rätsel: Initialisierungsreihenfolge von Feldern</b>
 *
 * <p>Dieses kleine Programm hat einen subtilen Stolperstein. Die spannende
 * Frage: Was gibt {@code main} aus – und <i>warum</i>?</p>
 *
 * <pre>
 *   int i = getInt();   // ← Feld i wird hier initialisiert,
 *                       //    ruft getInt() auf und braucht dafür j
 *   int j = 42;         // ← Feld j wird ERST jetzt auf 42 gesetzt
 * </pre>
 *
 * <p>In Java werden Felder in der <b>Reihenfolge ihrer Deklaration</b>
 * initialisiert. Wenn {@code getInt()} während der Initialisierung von
 * {@code i} aufgerufen wird, ist {@code j} noch auf seinem Default-Wert
 * für {@code int}, also <b>0</b> – nicht 42. Die Methode liefert deshalb
 * {@code 0 + 1 = 1} zurück.</p>
 *
 * <p>Erst <b>nach</b> der Zeile {@code int i = getInt()} wird
 * {@code int j = 42} ausgewertet. Beim {@code main}-Aufruf ist also:</p>
 *
 * <ul>
 *   <li>{@code raetsel.i == 1} (zur Init-Zeit war j noch 0)</li>
 *   <li>{@code raetsel.j == 42} (am Ende der Konstruktor-Phase)</li>
 * </ul>
 *
 * <p><b>Ausgabe:</b> {@code 1 42}</p>
 *
 * <h2>Lernziele</h2>
 * <ul>
 *   <li>Reihenfolge von Feldinitialisierungen</li>
 *   <li>Default-Werte primitiver Typen ({@code int} = 0, {@code boolean} = false, …)</li>
 *   <li>Warum man Felder vorsichtig mit Methodenaufrufen initialisiert</li>
 * </ul>
 */
public class OutputQuiz2 {
    int i = getInt();
    int j = 42;

    public int getInt() {
        return j + 1;
    }

    public static void main(String[] args) {
        OutputQuiz2 raetsel = new OutputQuiz2();
        System.out.println(raetsel.i + " " + raetsel.j);
    }
}

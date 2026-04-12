/**
 * Sammlung rekursiver Beispielmethoden.
 *
 * <p>Jede Methode demonstriert einen Klassiker der Rekursion:
 * <ul>
 *   <li>{@link #cash(float, float, float)} – Zinseszins über {@code n} Jahre</li>
 *   <li>{@link #power(int, int)}          – ganzzahlige Potenz (iterativ als Vergleich)</li>
 *   <li>{@link #palindrom(String)}        – Palindrom-Prüfung durch Vergleich der
 *       äußeren Zeichen und Rekursion auf den Rest</li>
 *   <li>{@link #fak(int)}                 – Fakultät</li>
 *   <li>{@link #fib(int)}                 – Fibonacci-Zahlen (exponentielle
 *       Laufzeit wegen doppelter Rekursion)</li>
 * </ul>
 */
class Rek {

    public static void main(String[] args) {
        System.out.println(power(5, 5));
        System.out.println(cash(1000, 1, 2));
        System.out.println(palindrom("annb"));
    }

    /**
     * Berechnet das Kapital nach {@code jahre} Jahren Zinseszins.
     *
     * <p>Achtung: Die rekursive Formulierung ruft sich <b>zweimal</b>
     * selbst auf – damit läuft die Methode exponentiell in der Jahreszahl.
     * Die mathematisch saubere Formulierung wäre einfach
     * {@code kapital * (1 + zins/100)^jahre}.</p>
     */
    public static float cash(float kapital, float zins, float jahre) {
        if (jahre == 0) {
            return kapital;
        }
        return cash(kapital, zins, jahre - 1)
             + cash(kapital, zins, jahre - 1) * zins / 100;
    }

    /** Berechnet x^n iterativ (nicht rekursiv – zum Vergleich). */
    public static int power(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * Prüft rekursiv, ob {@code s} ein Palindrom ist.
     *
     * <p>Idee: Erstes und letztes Zeichen vergleichen; wenn sie gleich
     * sind, auf den „innenliegenden" Rest ({@code substring(1, len-1)})
     * rekursiv weitermachen. Basisfall: String mit 0 oder 1 Zeichen ist
     * trivial ein Palindrom.</p>
     */
    public static boolean palindrom(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return palindrom(s.substring(1, s.length() - 1));
    }

    /** Fakultät n! = n · (n-1)! mit Rekursionsanker 0! = 1. */
    public static long fak(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fak(n - 1);
    }

    /**
     * Fibonacci-Zahlen: fib(0)=0, fib(1)=1, fib(n) = fib(n-1) + fib(n-2).
     *
     * <p><b>Achtung:</b> Diese Implementierung ist rechenaufwendig
     * (Laufzeit ≈ O(φ^n) mit φ≈1,618). Für größere n gehört eine
     * Memoisierung oder iterative Variante her.</p>
     */
    public static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

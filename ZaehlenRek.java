public class ZaehlenRek {
    public static void main(String[] args) {
        int n = 1000; // Anzahl der Zahlen, die gezählt werden sollen
        System.out.println("Zahlen von 1 bis " + n + ":");
        zaehlen(n);
    }

    /**
     * Rekursive Methode, die die Zahlen von 1 bis n ausgibt.
     */
    public static void zaehlen(int n) {
        if (n > 0) {
            zaehlen(n - 1); // Rekursiver Aufruf mit n-1
            System.out.print(n + " "); // Ausgabe der aktuellen Zahl
        }
    }
    
}

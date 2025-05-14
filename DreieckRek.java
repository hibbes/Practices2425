public class DreieckRek {
    public static void main(String[] args) {
        int n = 3;
        mittigesDreieckAufsteigend(n, 1); // Aufsteigendes Dreieck
        // System.out.println();
        mittigesDreieckAbsteigend(n, n-1);  // Absteigendes Dreieck
    }

    public static void mittigesDreieckAufsteigend(int n, int sternAnzahl) {
        // Rekursionsanker (Basisfall)
        if (sternAnzahl > n) {
            return;
        }
        // Sterne drucken
        for (int i = 0; i < sternAnzahl; i++) {
            System.out.print("*");
        }
        System.out.println();
        // Rekursiver Aufruf
        mittigesDreieckAufsteigend(n, sternAnzahl + 1);
    }

    public static void mittigesDreieckAbsteigend(int n, int sternAnzahl) {
        // Rekursionsanker (Basisfall)
        if (sternAnzahl == 0) {
            return;
        }
        // Sterne drucken
        for (int i = 0; i < sternAnzahl; i++) {
            System.out.print("*");
        }
        System.out.println();
        // Rekursiver Aufruf
        mittigesDreieckAbsteigend(n, sternAnzahl - 1);
    }
}
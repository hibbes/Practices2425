public class Probedivision {
    // Methode zur Überprüfung, ob eine Zahl prim ist
    public static boolean isPrime(int number) {
        if (number <= 1) return false; // Zahlen ≤ 1 sind keine Primzahlen
        // Schleife von 2 bis zur Quadratwurzel der Zahl
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            // TODO: Implementiere die Teilbarkeitsprüfung
            if (number % divisor == 0) {
                return false; // Zahl ist durch divisor teilbar, also keine Primzahl
            }
        }
        return true; // Wenn keine Teilbarkeit gefunden wurde, ist die Zahl prim
    }

    public static void main(String[] args) {
        int limit = 1000000; // Obergrenze für die Primzahlsuche
        // Schleife von 2 bis zur Obergrenze
        for (int currentNumber = 2; currentNumber <= limit; currentNumber++) {
            // TODO: Rufe isPrime auf und gib die Primzahlen aus
            if (isPrime(currentNumber)) {
                System.out.println(currentNumber + " ist eine Primzahl.");
            }
        }
    }
}

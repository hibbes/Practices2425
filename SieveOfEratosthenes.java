import java.util.Arrays;

public class SieveOfEratosthenes {
    // Methode zur Implementierung des Siebs des Eratosthenes
    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true); // Initialisiere alle Zahlen als prim
        isPrime[0] = isPrime[1] = false; // 0 und 1 sind keine Primzahlen

        // Schleife von 2 bis zur Quadratwurzel der Obergrenze
        for (int currentPrime = 2; currentPrime <= Math.sqrt(limit); currentPrime++) {
            if (isPrime[currentPrime]) {
                // TODO: Implementiere das Markieren der Vielfachen von currentPrime
                for (int multiple = currentPrime * currentPrime; multiple <= limit; multiple += currentPrime) {
                    if (isPrime[multiple]) {
                        isPrime[multiple] = false; // Markiere Vielfaches als nicht prim
                        // Optional: Weitere Aktionen bei der Markierung
                    }
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        int limit = 1000000; // Obergrenze für die Primzahlsuche
        boolean[] primes = sieveOfEratosthenes(limit);

        // Schleife von 2 bis zur Obergrenze, um Primzahlen auszugeben
        for (int number = 2; number <= limit; number++) {
            // TODO: Gib die Primzahlen aus
            if (primes[number]) {
                System.out.println(number + " ist eine Primzahl.");
            }
        }
    }
}

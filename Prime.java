import java.util.ArrayList;
import java.util.List;

class Prime {

    public static void main(String[] args) {

        System.out.println(output(generatePrimes(100)));
    }

    public static boolean isPrime(int candidate) {
        for (int divider = 2; divider <= Math.sqrt(candidate); divider++) {
            if (candidate % divider == 0)
                return false;
        }
        return true;
    }

    public static List<Integer> generatePrimes(int max) {
        List<Integer> primes = new ArrayList<>();
        for (int candidate = 2; candidate <= max; candidate++) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
        }
        return primes;
    }

    public static String output(List<Integer> primes) {
        int counter = 0;
        String output = "";
        for (Integer prime : primes) {
            output = output + " " + prime;
            counter++;
        }
        output = output+"\nMenge: "+counter;
        return output;
    }

}

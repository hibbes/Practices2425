public class fakRek {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Die Fakultät von " + n + " ist: " + fakultaet(n));
    }

    public static int fakultaet(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fakultaet(n - 1);
        }
    }
}

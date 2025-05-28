public class Dez2BinRek {
    public static void main(String[] args) {
        int dezimal = 13; // Beispielwert
        
        System.out.println("Die Binärdarstellung von " + dezimal + " ist: " + dez2bin(dezimal));
    }

    public static String dez2bin(int dezimal) {
        if (dezimal == 0) {
            return "0";}
       
            return dez2bin(dezimal / 2) + (dezimal % 2);
        }
    }
    



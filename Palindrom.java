public class Palindrom {
    static String palindrom ="EineHordebedrohenie";

    public static void main(String[] args) {
        System.out.println("Das Wort " + palindrom + " ist ein Palindrom: " + istPalindrom(palindrom));
    }

    public static boolean istPalindrom(String palindrom) {
        String test ="";
        for (int i = palindrom.length()-1; i >=0; i--) {
            test += palindrom.charAt(i);
            System.out.println(test);
            }
        if (test.equalsIgnoreCase(palindrom)) {
            return true;
        
        }
        return false;
    }
}

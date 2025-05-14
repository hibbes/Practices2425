public class Test {
    public static void main(String[] args) {
        List liste = new List(22);
        liste.anhaengen(34);
        liste.anhaengen(51);
        liste.anhaengen(6);
        System.out.println("Die Liste ist: ");
        liste.get();
        System.out.println(liste.finde(6));
        System.out.println(liste.finde(7));
        liste.entferneBei(2);
        liste.get();



    }
}

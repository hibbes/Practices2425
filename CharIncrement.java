public class CharIncrement {

    public static void main(String[] args) {
        String klartext = "ZAUN";
                
        System.out.println("Original: " + klartext);
        System.out.println("Geheimtext: " + caeser1(klartext));

   }
   public static String caeser1(String klartext) {
        String geheimtext="";
        char temp;
        for(int i = 0; i < klartext.length(); i++) {
            temp = klartext.charAt(i);
            temp++;
            if(temp > 'Z') {
                temp = 'A';
            }
            geheimtext+=temp;
            
        }
        return geheimtext;
   }
}

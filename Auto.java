public class Auto extends Fahrzeug
{

   public Auto(String name, int geschwindigkeit){
       super(name,geschwindigkeit);}

    public void fahren(){
        System.out.println("Das Auto fährt auf der Straße");
        
    }
    public void anzahlRaeder(){
        System.out.println("Das Auto hat 4 Räder");
    }
}

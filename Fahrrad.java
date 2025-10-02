public class Fahrrad extends Fahrzeug{

    public Fahrrad(String name, int geschwindigkeit){
        super(name,geschwindigkeit);
    }
    
    public void fahren(){
        System.out.println("Das Fahrrad fährt auf dem Radweg");
    }
    public void anzahlRaeder(){
        System.out.println("Das Fahrrad hat 2 Räder");
    }

}

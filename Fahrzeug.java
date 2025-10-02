public abstract class Fahrzeug {
    String name;
    int geschwindigkeit;

    public Fahrzeug(String name, int geschwindigkeit){
        this.name=name;
        this.geschwindigkeit=geschwindigkeit;
    }

    public abstract void fahren();
    public void info(){
        System.out.println("Fahrzeug: " + name + ", Geschwindigkeit: " + geschwindigkeit);
    }

    public abstract void anzahlRaeder();

}

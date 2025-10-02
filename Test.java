public class Test {
static Fahrzeug[] fahrzeuge = new Fahrzeug[4];
    public static void main(String[] args) {
       
        fahrzeuge[0] = new Auto("BMW", 100);
        fahrzeuge[1] = new Fahrrad("Mountainbike", 30);
        fahrzeuge[2] = new Auto("Audi", 120);
        fahrzeuge[3] = new Fahrrad("Citybike", 20);

        Fahrzeug f1 = new Auto("Citroen", 80);
        f1.name = "BMW";
        f1.geschwindigkeit = 120;
        

        Fahrzeug f2 = new Fahrrad("Kona",24);
        f2.name = "Mountainbike";
        f2.geschwindigkeit = 30;
       
        for (int i=0; i<fahrzeuge.length; i++){
            fahrzeuge[i].info();
            fahrzeuge[i].fahren();
        }



    }
}

public class List {
    public ListenElement kopf;

    
    public List(int wert) {
        kopf = new ListenElement(wert);
    }
 
    public void entferneBei(int index) {
        if (index == 0) {
            kopf = kopf.nachfolger;
        } else {
            kopf.entferneBei(index - 1);
        }
    }

    public int getlLaenge() {
        return kopf.getlLaenge();
    }

    public <T> void anhaengen(T daten) {

        kopf.anhaengen(new ListenElement(daten));

    }
    

    public boolean finde(int wert) {
        return kopf.finde(wert);    
    }
      
        public void get(){
        kopf.get();
     }
     

    public static void main(String[] args) {
        List l1 = new List(1);
        l1.anhaengen(2);
        l1.anhaengen(3);
        l1.anhaengen(4);
        // l1.get();

    }

}

public class Listenknoten<Integer> {
    public Integer daten; // Daten des Knotens
    public Listenknoten<Integer> nachfolger; // Verweis auf den nächsten Knoten

    // Konstruktor
    public Listenknoten(Integer daten, Listenknoten<Integer> nachfolger) {
        this.daten = daten;
        this.nachfolger = nachfolger;
    }

    public void enqueue(T x){
        dieListe.anhaengen(x);
      }

      public T dequeue(){
        T x = dieListe.get(0)
        dieListe.entferneBei(0);
        return x;

        public void anhaengen(T x){
            if(anfang==null){
                anfang = new Listenknoten<Integer>(x, null)}
                else{
                    Listenknoten<Integer> k = anfang;
                }                
                    while(k.nachfolger!= null){
                        k = k.nachfolger;
                    }
                    k.nachfolger= new Listenknoten<Integer>(x, null);
                }
                



      }
    }
    
}

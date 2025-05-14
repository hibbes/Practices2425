public class QueueWithList<T> {
    private List dieListe;
    
    public QueueWithList() {
        dieListe = new List(0);    
    }
    public ListenElement<T> dequeue(int wert) {
      
      ListenElement<T> temp = dieListe.kopf;
      dieListe.entferneBei(wert);
      return temp;
    }

    public void enqueue(ListenElement<T> knoten) {
        dieListe.anhaengen(knoten.daten);
    }
}

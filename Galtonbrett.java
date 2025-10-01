public class Galtonbrett 
    public Galtonbrett(){

    Behaelter b1 = new Behaelter();
    Behaelter b2 = new Behaelter();
    Behaelter b3 = new Behaelter();
    Behaelter b4 = new Behaelter();

    Hindernis h6 = new Hindernis(b3,b4);
    Hindernis h5 = new Hindernis(b2,b3);
    Hindernis h4 = new Hindernis(b1,b2);
    
    Hindernis h3 = new Hindernis(h5,h6);
    Hindernis h2 = new Hindernis(h4,h5);
       
    start = new Hindernis(h1,h2);

}
 public void simuliere(){
    Knoten k = start;
    while(k != null){
       k=k.verarbeite();
    }

 }

}

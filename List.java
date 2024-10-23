public class List {
    private ListenElement kopf;


    public List(int inhalt){
        kopf = new ListenElement(inhalt);
    }

    public void add(int inhalt){
       kopf.add(new ListenElement(inhalt));

    }

    public void get(){
        kopf.get();
    }

    public static void main(String[] args) {
        List l1 = new List(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.get();
        


}

}

public class ListenElement {
    
    private int inhalt;
    private ListenElement next;

    public ListenElement (int inhalt){
        this.inhalt=inhalt;
    }

    public void add(ListenElement neu){
       if(next==null){
        next=neu;
        }else{
            next.add(neu);
        }
       }

    public void get(){
    System.out.println(inhalt);
       if(next!=null){
        next.get();
        } 
     
    }

}    


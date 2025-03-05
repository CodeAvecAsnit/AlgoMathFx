package Calculate;

public class Linked {
    public Internode head;

    public Linked(){
        this.head=null;

    }
    public void add(Internode newnode){
        if(head!=null){
            newnode.next=head;
        }
        head=newnode;
    }
}

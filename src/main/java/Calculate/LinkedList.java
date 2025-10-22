package Calculate;

/**
 * @author : Asnit Bakhati
 */

public class LinkedList {
    public InterNode head;

    public LinkedList(){
        this.head=null;

    }
    public void add(InterNode newNode){
        if(head!=null){
            newNode.next=head;
        }
        head=newNode;
    }
}

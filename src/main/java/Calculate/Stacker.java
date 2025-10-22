package Calculate;
import java.util.Stack;


/**
 * @author : Asnit Bakhati
 */

public class Stacker {

    public static class node{
        public String data;
        public node next;
        node(String d){
            this.data=d;
        }
    }

    private node head;

    public int count;

    Stacker(){
        this.head=null;
    }

    public boolean IsEmpty(){
        return head==null;
    }

    public void push(String arg){
        ++count;
        node newnode = new node(arg);
        if(!IsEmpty()){
            newnode.next=head;
        }
        head=newnode;
    }


    public void pop(){
        if(IsEmpty()){
            System.out.println("Error");
        }else{
            --count;
            head=head.next;
        }
    }


    public void pop2(){
        if(IsEmpty()||head.next==null){
            System.out.println("Error");
        }else if(head.next.next==null){
            --count;
            head.next=null;
        }else{
            --count;
            head.next=head.next.next;
        }
    }


    public void display(){
        if(!IsEmpty()){
            node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }


    public String getLast(){
        if(IsEmpty()){
            System.out.println("Error");
            return null;
        }else{
            return head.data;
        }
    }


    public String getSecond(){
            if(IsEmpty()||head.next==null){
                System.out.println("Error");
                return null;
        }else{
                return head.next.data;
            }
    }

  public double calculate(){
        Stack<Double> ds=new Stack<>();
        Checker t=new Checker();
         node bird=head;
         while(bird!=null){
             if(t.check_Sign(t.characterize(bird.data))){
                 double k=ds.pop();
                 double l=ds.pop();
                 switch (t.characterize(bird.data)){
                     case '+':
                         ds.push(k+l);
                         break;

                     case '-':
                         ds.push(l-k);
                         break;

                     case '*':
                         ds.push(l*k);
                         break;

                     case '/':
                         ds.push(l/k);
                         break;

                     case '^':
                         int kk=(int)k;
                         ds.push(getPower(l,kk));
                         break;

                     default:
                         System.out.println("Error");
                 }

             }else{
                 ds.push(Double.parseDouble(bird.data));
             }
             bird=bird.next;
         }

return ds.pop();
  }

  private double getPower(double a, int b){
        if(b==0){
            return 1;
        }else if(b==1){
            return a;
        }else{
            return a* getPower(a,b-1);
        }
  }
}



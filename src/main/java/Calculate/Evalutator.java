package Calculate;

/**
 * @author : Asnit Bakhati
 * This code is now replaced with faster and smoother version
 */

public class Evalutator {

    private final Stacker Opcode=new Stacker();
    private final Stacker rev=new Stacker();
    private final Stacker Operator=new Stacker();


    private boolean check_Sign(char a){
        return (a=='-'||a=='+'||a=='*'||a=='('||a==')'||a=='/'||a=='^'||a=='&');
    }

    @Deprecated
    public void separate(String d){
        if(check_Sign(d.charAt(0))){
            Operator.push(d);
            if(Operator.count>1){
                precedence(characterize(Operator.getLast()),characterize(Operator.getSecond()));
            }
            if(Operator.getLast().equals(")")){
                Operator.pop();
                while(!Operator.getLast().equals("(")){
                    Opcode.push(Operator.getLast());
                    Operator.pop();
                }
                Operator.pop();
            }
        }else{
            Opcode.push(d);
        }
    }

    @Deprecated
    public double see(){
        while(!Operator.IsEmpty()){
            Opcode.push(Operator.getLast());
            Operator.pop();
        }
        while(!Opcode.IsEmpty()){
            rev.push(Opcode.getLast());
            Opcode.pop();
        }
        return rev.calculate();
    }



    @Deprecated
    private void precedence(char last,char last2){
     if(last2=='^'||last2=='&'){
         Opcode.push(Operator.getSecond());
         Operator.pop2();
     }else if(last2=='*'||last2=='/'){
         if(last=='+'||last=='/'||last=='*'||last=='-'){
             Opcode.push(Operator.getSecond());
             Operator.pop2();
         }
     }else if(last2=='-'||last2=='+'){
         if(last=='-'||last=='+'){
             Opcode.push(Operator.getSecond());
             Operator.pop2();
         }
     }
    }

    @Deprecated
    private char characterize(String str){
        return str.charAt(0);
    }

}
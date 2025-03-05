package Calculate;
public class Evalutate{
    private final stacker Opcode=new stacker();
    private final stacker rev=new stacker();
    private final stacker Operator=new stacker();
    private boolean check_Sign(char a){
        return (a=='-'||a=='+'||a=='*'||a=='('||a==')'||a=='/'||a=='^'||a=='&');
    }

    public void separate(String d){
        if(check_Sign(d.charAt(0))){
            Operator.push(d);
            if(Operator.count>1){
                precedence(characterize(Operator.get_last()),characterize(Operator.get_2nd()));
            }
            if(Operator.get_last().equals(")")){
                Operator.pop();
                while(!Operator.get_last().equals("(")){
                    Opcode.push(Operator.get_last());
                    Operator.pop();
                }
                Operator.pop();
            }
        }else{
            Opcode.push(d);
        }
    }

    public double see(){
        while(!Operator.IsEmpty()){
            Opcode.push(Operator.get_last());
            Operator.pop();
        }
        while(!Opcode.IsEmpty()){
            rev.push(Opcode.get_last());
            Opcode.pop();
        }
        return rev.calculate();
    }



    private void precedence(char last,char last2){
     if(last2=='^'||last2=='&'){
         Opcode.push(Operator.get_2nd());
         Operator.pop2();
     }else if(last2=='*'||last2=='/'){
         if(last=='+'||last=='/'||last=='*'||last=='-'){
             Opcode.push(Operator.get_2nd());
             Operator.pop2();
         }
     }else if(last2=='-'||last2=='+'){
         if(last=='-'||last=='+'){
             Opcode.push(Operator.get_2nd());
             Operator.pop2();
         }
     }
    }

    private char characterize(String str){
        return str.charAt(0);
    }




}
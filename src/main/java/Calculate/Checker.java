package Calculate;


/**
 * @author : Asnit Bakhati
 */

public class Checker {

    public char characterize(String str){
        return str.charAt(0);
    }
    public boolean check_Sign(char a){
        return (a=='-'||a=='+'||a=='*'||a=='('||a==')'||a=='/'||a=='^'||a=='&');
    }

}



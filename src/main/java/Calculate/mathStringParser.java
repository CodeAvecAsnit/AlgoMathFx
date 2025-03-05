package Calculate;


import java.util.Scanner;

public class mathStringParser{


    public static void Parse(String a,float x){
        a=a.replace("x",String.valueOf(x));
        System.out.println(a);
        Get_result ni = new Get_result();
        String now = ni.Calculator_program(a+"*1");
        System.out.println(now);
    }
}


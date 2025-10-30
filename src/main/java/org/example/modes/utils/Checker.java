package org.example.modes.utils;


/**
 * @author : Asnit Bakhati
 */

public class Checker {

    @Deprecated
    public char characterize(String str){
        return str.charAt(0);
    }

    @Deprecated
    public boolean check_Sign(char a){
        return (a=='-'||a=='+'||a=='*'||a=='('||a==')'||a=='/'||a=='^'||a=='&');
    }

}



package Calculate;

/**
 * @author : Asnit Bakhati
 */

public class CalculatorProgram {

    @Deprecated
    public String calculate(String equation){


        Evalutator calculate = new Evalutator();
        char[] curry = equation.toCharArray();


        int start = 0;
        Checker tester = new Checker();
        for (int i = 0; i < equation.length(); ++i) {
            if (tester.check_Sign(curry[i])) {
                if (i > start) {
                    calculate.separate(equation.substring(start, i));
                }
                calculate.separate(Character.toString(curry[i]));
                start = i + 1;
            }
        }

        if (start < equation.length() || (start == equation.length() && tester.check_Sign(curry[equation.length() - 1]))) {
            calculate.separate(equation.substring(start));
        }

        return String.valueOf(calculate.see());
    }

}
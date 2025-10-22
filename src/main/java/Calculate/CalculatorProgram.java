package Calculate;

/**
 * @author : Asnit Bakhati
 */

public class CalculatorProgram {

    public String Calculator_program(String cpu){


        Evalutator calculate = new Evalutator();
        char[] curry = cpu.toCharArray();


        int start = 0;
        Checker tester = new Checker();
        for (int i = 0; i < cpu.length(); ++i) {
            if (tester.check_Sign(curry[i])) {
                if (i > start) {
                    calculate.separate(cpu.substring(start, i));
                }
                calculate.separate(Character.toString(curry[i]));
                start = i + 1;
            }
        }


        if (start < cpu.length() || (start == cpu.length() && tester.check_Sign(curry[cpu.length() - 1]))) {
            calculate.separate(cpu.substring(start));
        }

        return String.valueOf(calculate.see());
    }

}
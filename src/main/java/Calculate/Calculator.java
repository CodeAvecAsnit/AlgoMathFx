package Calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Asnit Bakhati
 */
public class Calculator {

    int precedence(String op) {
        return switch (op) {
            case "^" -> 4;  // Power - highest precedence
            case "~" -> 3;  // Unary minus
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
    }

    /**
     * Generate the reverse polish notation from given String
     * @param infix is the original arithmetical string
     * @return postfix notation as string
     */
    private List<String> toPostfix(String infix) throws Exception{
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int i = 0;

        while (i < infix.length()) {
            char ch = infix.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(ch)) {
                StringBuilder number = new StringBuilder();
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    number.append(infix.charAt(i));
                    i++;
                }
                postfix.add(number.toString());
                continue;
            }

            if (ch == '(') {
                stack.push("(");
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            }
            else {
                String op = String.valueOf(ch);

                if (op.equals("-")) {
                    boolean isUnary = (i == 0);
                    if (!isUnary) {
                        int j = i - 1;
                        while (j >= 0 && infix.charAt(j) == ' ') {
                            j--;
                        }
                        if (j < 0 || infix.charAt(j) == '(') {
                            isUnary = true;
                        }
                    }
                    if (isUnary) {
                        op = "~";
                    }
                }

                if (op.equals("^")) {
                    while (!stack.isEmpty() && precedence(stack.peek()) > precedence(op) && !stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(op) && !stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }
                }
                stack.push(op);
            }
            i++;
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    /**
     *
     * @param s is the given arithmetic string
     * @return calculated value that is evaluated using postfix evaluation
     * @throws Exception any kind of error that might occur due improper input
     */
    public int calculate(String s)throws Exception {
        List<String> tokens = toPostfix(s);
        Stack<Integer> numStack = new Stack<>();
        int second = 0;

        for (String token : tokens) {
            switch (token) {
                case "~":
                    numStack.push(-1 * numStack.pop());
                    break;

                case "^":
                    second = numStack.pop();
                    int first = numStack.pop();
                    numStack.push((int) Math.pow(first, second));
                    break;

                case "+":
                    second = numStack.pop();
                    numStack.push(numStack.pop() + second);
                    break;

                case "-":
                    second = numStack.pop();
                    numStack.push(numStack.pop() - second);
                    break;

                case "*":
                    second = numStack.pop();
                    numStack.push(numStack.pop() * second);
                    break;

                case "/":
                    second = numStack.pop();
                    numStack.push(numStack.pop() / second);
                    break;

                default:
                    numStack.push(Integer.parseInt(token));
                    break;
            }
        }
        return numStack.pop();
    }
}
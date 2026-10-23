package Task1_ValidParentheses;
import java.util.Stack;

public class ValidParentheses {

    public static boolean validik(String s) {
        Stack<Character> stack = new Stack<>();

        for (char cc : s.toCharArray()) {

            if (cc == '(') {
                stack.push(')');
            } else if (cc == '{') {
                stack.push('}');
            } else if (cc == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != cc) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
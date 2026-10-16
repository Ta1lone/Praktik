import java.util.ArrayDeque;

public class ParenCheck {

    public static boolean valid(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char high = stack.pop();

                if (c == ')' && high != '(') return false;
                if (c == ']' && high != '[') return false;
                if (c == '}' && high != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
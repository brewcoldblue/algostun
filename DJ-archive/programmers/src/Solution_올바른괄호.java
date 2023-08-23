import java.util.Stack;

public class Solution_올바른괄호 {

    class Solution {

        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push('(');
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        answer = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                answer = false;
            }

            return answer;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<String> st = new Stack<>();
        int ans = 1;
        try {
            for (int i = 0; i < str.length(); i++) {
                String tmp = str.substring(i, i + 1);
                if (tmp.equals("(") || tmp.equals("[")) {
                    if (ans != 1) {
                        st.add(Integer.toString(ans));
                        ans = 1;
                    }
                    st.add(tmp);
                } else if (tmp.equals(")") || tmp.equals("]")) {
                    while (!st.peek().equals("(") && !st.peek().equals("["))
                        ans += Integer.parseInt(st.pop());
                    if (st.peek().equals("(") && tmp.equals(")")) {
                        ans *= 2;
                        st.pop();
                    } else if (st.peek().equals("[") && tmp.equals("]")) {
                        ans *= 3;
                        st.pop();
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
            while (!st.isEmpty()) ans += Integer.parseInt(st.pop());
        } catch (Exception e) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ans = new int[N+1];
        Stack<int[]> st = new Stack<>();
        st.add(new int[] {Integer.MAX_VALUE, 0});
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(stk.nextToken());

            if (st.peek()[0] <= now) {
                while (st.peek()[0] <= now) st.pop();
            }
            ans[i] = st.peek()[1];
            st.add(new int[] {now, i});
        }

        for (int i = 1; i <= N; i++) System.out.print(ans[i]+" ");
        System.out.println();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            ar[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            int now = ar[i];
            while(!stk.isEmpty() && ar[stk.peek()] < now)
                ans[stk.pop()] = now;
            stk.push(i);
        }
        while(!stk.isEmpty()) ans[stk.pop()] = -1;

        for (int i = 0; i < N; i++) sb.append(ans[i] + " ");
        System.out.println(sb);
    }
}


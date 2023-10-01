package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_아름다운수 {
    static int n;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        bt(sb, 0);

        System.out.println(ans);

    }

    private static void bt(StringBuilder sb, int idx) {
        if (sb.length() == n) {
            ans++;
            return;
        }

        if (sb.length()+1 <= n) bt(sb.append("1"), idx+1);
        sb.delete(idx, idx+1);
        if (sb.length()+2 <= n) bt(sb.append("22"), idx+2);
        sb.delete(idx, idx+2);
        if (sb.length()+3 <= n) bt(sb.append("333"), idx+3);
        sb.delete(idx, idx+3);
        if (sb.length()+4 <= n) bt(sb.append("4444"), idx+4);
        sb.delete(idx, idx+4);
    }

}

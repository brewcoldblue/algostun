package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_특정조건에맞게k개중에1개를n번뽑기 {

    public static int n,m;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        permutation(new int[m], 0);
        System.out.print(sb);
    }

    private static void permutation(int[] ans, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt >= 2 && i == ans[cnt-1] && i==ans[cnt-2]) {
                continue;
            }
            ans[cnt] = i;
            permutation(ans, cnt+1);
            ans[cnt] = 0;
        }
    }

}

package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_k개중에1개를n번뽑기 {

    static int K,N;
    //중복순열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        bt(new int[N], 0);

    }

    private static void bt(int[] ans, int cnt) {
        if (cnt == N) {
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= K; i++) {
            ans[cnt] = i;
            bt(ans, cnt+1);
        }
    }

}

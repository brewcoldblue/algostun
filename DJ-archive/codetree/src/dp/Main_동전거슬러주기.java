package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_동전거슬러주기 {

    // 지금까지 선택한 동전의 합이 i라 했을 때, 가능한 최소 동전의 개수
    // 합 i를 만들기 위해 마지막으로 사용한 동전이 j번째 동전(coin[j])인 경우
    // dp[i] = min (dp[i-coin[j]) + 1 (i<=j<=n, i>=coin[j])
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] coins = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (i-coins[j]>=0) {
                    if (dp[i-coins[j]] == Integer.MAX_VALUE) continue; // ***
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]) + 1;
                }
            }
        }

        if (dp[N] == Integer.MIN_VALUE) dp[N] = -1;
        System.out.println(dp[N]);
    }
}

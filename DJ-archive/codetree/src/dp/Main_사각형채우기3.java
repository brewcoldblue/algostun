package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_사각형채우기3 {

    // dp[n] = 2 × n 크기의 사각형을 1 × 2, 2 × 1, 1 x 1 크기의 사각형들로 채우는 방법의 수
    // dp[1]=2, dp[2]=3, 그 뒤부터는 2개씩 관찰된다.
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1005];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] * 2 + dp[i - 2] * 3;
            dp[i] %= MOD;
            for (int j = i - 3; j >= 0; j--) {
                dp[i] = (dp[i] + dp[j] * 2) % MOD;
            }
        }
        System.out.println(dp[N]);
    }

}

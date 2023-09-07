package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_사각형채우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1005];
        // dp[i] = 2*i 사각형에서 1 × 2, 2 × 1 크기의 사각형들로 채우는 방법의 수
        dp[1] = 1;
        dp[2] = 2;
        // dp[i-2] + dp[i-1]

        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
            dp[i] %= 10007;
        }

        System.out.println(dp[N]);
     }

}

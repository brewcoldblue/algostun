package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_계단오르기 {

    // 초기값 어디까지 있어야 하는지 잘 보기
    // 문제 잘 읽자. (나머지 구하기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1005];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i < N + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
            dp[i] %= 10007;
        }

        System.out.println(dp[N]);
    }

}

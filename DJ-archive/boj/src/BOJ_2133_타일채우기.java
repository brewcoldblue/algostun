import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133_타일채우기 {

    /* dp[n] = 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수
     * 1. n이 홀수일 때 경우의 수 0
     * 2. n이 짝수일 경우 dp[2] = 3이고 다른 경우들은 2개씩 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[33];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 3; i < N + 1; i++) {
            if (i % 2 == 1) {
                dp[i] = 0;
            } else {
                dp[i] = 3 * dp[i - 2];
                for (int j = i - 4; j >= 0; j--) {
                    dp[i] = dp[i] + dp[j] * 2;
                }
            }
        }

        System.out.println(dp[N]);

    }

}

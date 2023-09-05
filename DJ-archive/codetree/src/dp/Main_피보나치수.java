package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// int, long 범위 주의
// 초기값 런타임 에러 주의
public class Main_피보나치수 {

    static long[] memo;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new long[N+1];
        Arrays.fill(memo, -1);
        /*
         * 1. 재귀 메모이제이션
         * 2. for문 tabulation (bottom-up)
         */

        // 첫번째 방법
        // int ans = fibboByMemo(N);

        // 두번째 방법
        long ans = 0;
        dp = new long[50]; // ** N으로 하니 런타임에러 나서 고정값으로 변경
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        ans = dp[N];
        System.out.println(ans);
    }


    private static long fibboByMemo(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n <=2) {
            memo[n] = 1;
        } else memo[n] = fibboByMemo(n-1) + fibboByMemo(n-2);

        return memo[n];
    }


}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        if(N == 0 || N == 1) {
            System.out.println(0);
            return;
        }
        dp[2] = 3;
        for (int i = 4; i <= N; i++) {
            if(i%2==1) continue;
            
            int tmp = dp[i-2] * 3 + 2;
            for (int j = 2; j <= i-4; j++) {
                if (j % 2 == 1) continue;
                tmp += dp[j] * 2;
            }
            dp[i] = tmp;
        }

        System.out.println(dp[N]);
    }
}


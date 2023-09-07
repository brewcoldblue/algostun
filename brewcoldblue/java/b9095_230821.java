import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); 
        int[] dp = new int[11]; 
        
        // 1, 2, 3을 만드는 방법의 수는 각각 1, 2, 4
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // 4부터 10까지
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}

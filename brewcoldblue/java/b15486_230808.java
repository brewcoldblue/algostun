import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N+1) {
                dp[i + T[i] - 1] = Math.max(dp[i + T[i] - 1], answer + P[i]);
            }
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }
}

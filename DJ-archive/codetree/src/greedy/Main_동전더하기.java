package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_동전더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전 종류
        int k = Integer.parseInt(st.nextToken()); // 금액
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        int money = k;
        int cnt = 0;
        for (int i = n-1; i >= 0; i--) {
            if (money > coins[i]) {
                cnt += (money / coins[i]);
                money %= coins[i];
            }
        }
        System.out.println(cnt);

    }

}

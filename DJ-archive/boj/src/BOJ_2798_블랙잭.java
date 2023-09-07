import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {

    static int[] nums;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        combination(N, M, 0, 0, new boolean[N], 0);
        System.out.println(max);
    }

    private static void combination(int n, int m, int k, int start, boolean[] isUsed, int sum) {
        if (sum > m) {
            return;
        }
        if (k == 3) {
            if (max < sum) max = sum;
            return;
        }

        for (int i = start; i < n; i++) {
            if (isUsed[i]) continue;
            sum += nums[i];
            isUsed[i] = true;
            combination(n, m,k+1, i, isUsed, sum);
            sum -= nums[i];
            isUsed[i] = false;
        }
    }

}

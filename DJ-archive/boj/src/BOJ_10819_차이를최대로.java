import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

    static int[] nums;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        permutation(N, 0, new boolean[N], new int[N]);
        System.out.println(max);
    }


    private static void permutation(int N, int k, boolean[] isUsed, int[] ans) {
        if (k == N) {
            int tmp = solve(ans);
            if (max < tmp) {
                max = tmp;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isUsed[i]) {
                continue;
            }
            ans[k] = nums[i];
            isUsed[i] = true;
            permutation(N, k + 1, isUsed, ans);
            isUsed[i] = false;
        }

    }


    private static int solve(int[] ans) {
        int sum = 0;
        for (int i = 0; i < ans.length - 1; i++) {
            sum += Math.abs(ans[i] - ans[i + 1]);
        }
        return sum;
    }

}

package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.codetree.ai/missions/2/problems/longest-decreasing-subsequence?&utm_source=clipboard&utm_medium=text
 */
public class Main_최대감소부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화!! 자기 자신만 수열인 경우, 최대 길이 1인 수열 가능
        int[] d = new int[N + 1];
        Arrays.fill(d, 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        int max = 1; // N이 1일 때 최대값 1
        for (int i = 1; i <= N; i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }
        System.out.println(max);
    }

}

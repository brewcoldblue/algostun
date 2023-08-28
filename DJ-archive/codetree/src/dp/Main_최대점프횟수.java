package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * https://www.codetree.ai/missions/2/problems/maximum-number-of-jumps?&utm_source=clipboard&utm_medium=text
 */
public class Main_최대점프횟수 {

    // "시작 위치"로부터 최대 몇번 점프가 가능한가?
    // j < i, j + arr[j] >= i
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화!! 최대이므로 -1로 초기화
        int[] d = new int[N + 1];
        Arrays.fill(d, -1);

        // 초기값 (시작위치는 세지 않는다.)
        d[1] = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (d[j] == -1) continue;
                if (j + arr[j] >= i) {
                    d[i] = Math.max(d[i], d[j] +1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] == -1) continue;
            if (max < d[i]) max = d[i];
        }

        System.out.println(max);
    }
}

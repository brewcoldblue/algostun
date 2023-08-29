import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

    // d[i][j] = i번째 집을 j색으로 칠한 경우 지금까지 비용의 최솟값 (j >> 0:R/1:G/2:B)
    // d[i][j] = min(d[i-1][j가 아닌 값], d[i-1][선택되지 않은 색]) + i번쨰 집을 j로 칠했을 때의 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 각 집마다 빨,초,파로 칠했을 때의 비용
        int[] r = new int[N+1];
        int[] g = new int[N+1];
        int[] b = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[N+1][3];
        // N은 2 이상 1000이하
        d[1][0] = r[1];
        d[1][1] = g[1];
        d[1][2] = b[1];

        // 점화식 채우기
        for (int i = 2; i <= N; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + r[i];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + g[i];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + b[i];
        }

        int answer = Math.min(d[N][0], d[N][1]);
        answer = Math.min(answer, d[N][2]);
        System.out.println(answer);
    }

}

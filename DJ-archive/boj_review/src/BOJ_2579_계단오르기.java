import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {

    // d[i][j] = 현재 연속해서 j개의 계단을 밟았고 현재 i번째 계단일 때 총 점수의 최댓값 (j는 1,2 가능)
    // d[i][2] = d[i-1][1] + score[k]
    // d[i][1] = max(d[i-2][1], d[i-2][2]) + score[k]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단의 수
        int[] scores = new int[N+1]; // 계단 당 점수
        // 점수 및 dp 배열 초기화
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        int[][] d = new int[N+1][3];

        // 초기값 (IndexOutOfError 주의)
        if (N == 1) {
            d[1][2] = 0;
            d[1][1] = scores[1];
        } else if (N >= 2) {
            d[1][2] = 0;
            d[1][1] = scores[1];
            d[2][1] = scores[2];
            d[2][2] = scores[1] + scores[2];
        }

        // 점화식 (dp 배열 채우기)
        for (int i = 3; i <= N; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + scores[i];
            d[i][2] = d[i-1][1] + scores[i];
        }

        // 정답 출력
        int answer = Math.max(d[N][1], d[N][2]);
        System.out.println(answer);
    }
}

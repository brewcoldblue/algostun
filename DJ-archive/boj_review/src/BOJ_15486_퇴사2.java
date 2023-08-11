import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] d = new int[N + 2];

        for (int i = 1; i <= N; i++) { // 수정된 부분: 0에서 시작하는 인덱스를 1에서 시작하는 인덱스로 변경
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            int nextDay = i + T[i];
            d[i] = Math.max(d[i], d[i + 1]); // 현재 날짜까지의 최대 수익
            if (nextDay <= N + 1) {
                d[i] = Math.max(d[i], d[nextDay] + P[i]); // 상담 완료 후 최대 수익 갱신
            }
        }
        System.out.println(d[1]); // 마지막 결과는 d[1]에 저장되어 있음
    }
}

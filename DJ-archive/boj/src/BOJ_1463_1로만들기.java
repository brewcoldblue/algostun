import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {

    // d[i] = i를 1로 만드는데 사용되는 연산의 최소 횟수
    // d[i] = min(d[i/3], d[i/2], d[i-1]) + 1
    // d[1] = 0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        d[1] = 0;
        for (int i = 2; i <= N; i++) {
            int tmp1 = Integer.MAX_VALUE, tmp2 = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                tmp1 = d[i / 2];
            }
            if (i % 3 == 0) {
                tmp2 = d[i / 3];
            }
            d[i] = Math.min(tmp1, tmp2);
            d[i] = Math.min(d[i], d[i-1]) + 1;
        }
        System.out.println(d[N]);
    }

}

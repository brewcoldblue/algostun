import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {

    // d[i] = i를 1,2,3의 합으로 만들 수 있는 방법의 수
    // d[i] = d[i-1] + d[i-2] + d[i-3]
    // d[1] = 1, d[2] = 2, d[3] = 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i < 12; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        for (int tk = 1; tk <= T; tk++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(d[n]).append("\n");
        }
        System.out.println(sb);
    }

}

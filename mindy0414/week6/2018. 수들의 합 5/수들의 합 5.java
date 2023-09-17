import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int srt = 0;
        int end = 0;
        int ans = 0;
        int now = 0;
        while(end <= N) {
            if(now == N) ans++;
            if(now <= N) {
                end++;
                if(end <= N) now += end;
            }
            if(now > N) {
                now -= srt;
                srt++;
            }
        }
        System.out.println(ans);

    }
}
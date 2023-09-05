import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] ar = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            ar[i] = Long.parseLong(st.nextToken());
        Arrays.sort(ar);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            long tar = ar[i];
            int srt = 0; int end = N-1;
            while(srt < end) {
                if(ar[srt]+ar[end] == tar) {
                    if(srt==i) srt++;
                    else if(end==i) end--;
                    else {
                        ans++;
                        break;
                    }
                }
                else if(ar[srt]+ar[end] < tar) srt++;
                else end--;
            }

         }
        System.out.println(ans);
    }
}
// 1 3 5 6 8 10
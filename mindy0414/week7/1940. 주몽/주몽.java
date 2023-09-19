import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            ar[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(ar);

        int srt = 0;
        int end = N-1;
        int ans = 0;
        while(srt < end) {
            if(ar[srt] + ar[end] > M) end--;
            else if(ar[srt] + ar[end] < M) srt++;
            else if(ar[srt] + ar[end] == M){
                ans++; srt++; end--;
            }
        }
        System.out.println(ans);
    }
}
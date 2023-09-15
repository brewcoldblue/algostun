import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ar = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
            sum += ar[i];
            max = Math.max(ar[i], max);
        }

        // 1 ~ sum 까지 binary search
        int l = max;
        int r = sum;
        while(true) {
            if(l == r) break;
            int mid = (l+r) / 2;
            int tmp = 0;
            int tmpM = 1;
            for (int i = 0; i < N; i++) {
                tmp += ar[i];
                if(tmp > mid) {
                    tmp = ar[i];
                    tmpM++;
                }
            }
            if(tmpM > M) l = mid+1;
            else if(tmpM <= M) r = mid;
        }
        System.out.println(r);

    }
}


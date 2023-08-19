import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==K) {
            System.out.println(0);
            return;
        }

        int ans = 0;
        int[] chk = new int[200001];
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
//        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{ N, 0 });
        chk[N]++;
        while(!q.isEmpty()) {
            int now = q.peek()[0];
            int t = q.poll()[1];
            if(now == K) { ans = t; break; }

            if(now*2 > 0 && now*2 <= 200000 && (chk[now*2] == 0 || chk[now*2] > t)){
                q.add(new int[]{now*2, t});
                chk[now*2] = t;
            }
            if(now+1 <= 100000 && (chk[now+1] == 0 || chk[now+1] > t)){
                q.add(new int[]{now+1, t+1});
                chk[now+1] = t+1;
            }
            if(now-1 >= 0 && (chk[now-1] == 0 || chk[now-1] > t)){
                q.add(new int[]{now-1, t+1});
                chk[now-1] = t+1;
            }

        }

        System.out.println(ans);
    }
}
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

        boolean[] chk = new boolean[N+1];
        ArrayList<Integer>[] ar = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) ar[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ar[a].add(b);
            ar[b].add(a);
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if(chk[i]) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            chk[i] = true;
            ans++;
            while(!q.isEmpty()) {
                int tmp = q.poll();
                for (int j = 0; j < ar[tmp].size(); j++) {
                    if(!chk[ar[tmp].get(j)]) {
                        chk[ar[tmp].get(j)] = true;
                        q.add(ar[tmp].get(j));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}


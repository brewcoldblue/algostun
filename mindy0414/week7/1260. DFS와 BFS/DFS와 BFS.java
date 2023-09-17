import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] al;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        al = new ArrayList[N+1];
        for(int i=1; i<=N; i++) al[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
            al[b].add(a);
        }
        for (int i = 1; i <= N; i++) Collections.sort(al[i]);

        chk = new boolean[N+1];
        DFS(V);
        System.out.println();
        chk = new boolean[N+1];
        BFS(V);
    }
    static void DFS(int v) {
        System.out.print(v+" ");
        chk[v] = true;

        for (int i = 0; i < al[v].size(); i++) {
            if(chk[al[v].get(i)]) continue;
            DFS(al[v].get(i));
        }

    }
    static Queue<Integer> q = new ArrayDeque<>();
    static void BFS(int v) {
        q.add(v);
        chk[v] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            System.out.print(tmp+" ");
            for (int i = 0; i < al[tmp].size(); i++) {
                if(chk[al[tmp].get(i)]) continue;
                chk[al[tmp].get(i)] = true;
                q.add(al[tmp].get(i));
            }
        }
    }
}


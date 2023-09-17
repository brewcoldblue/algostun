package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_그래프탐색 {

    static ArrayList<Integer>[] edgeList;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
        visited[1] = true;
        int cnt = dfs(1);
        System.out.println(cnt);
    }

    private static int dfs(int vertex) {
//        int cnt = 0; // 재귀할 때마다 0으로 갱신됨!!
        for (int i = 0; i < edgeList[vertex].size(); i++) {
            int curV = edgeList[vertex].get(i);
            if (!visited[curV]) {
                visited[curV] = true;
                cnt++;
                dfs(curV);
            }
        }
        return cnt;
    }
}

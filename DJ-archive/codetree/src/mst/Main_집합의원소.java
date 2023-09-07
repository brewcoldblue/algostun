package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온파인드 복습
public class Main_집합의원소 {

    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 유니온파인드 집합 초기화
        uf = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            uf[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int comm = Integer.parseInt(st.nextToken());
            if (comm == 0) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                int ans = findSet(Integer.parseInt(st.nextToken())) == findSet(
                        Integer.parseInt(st.nextToken())) ? 1 : 0;
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);

        if (rootX != rootY) {
            uf[rootX] = rootY;
        }

    }

    private static int findSet(int x) {
        if (uf[x] == x) {
            return x;
        }
        return uf[x] = findSet(uf[x]);
    }

}

package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_경로의적합성판단2 {

    static int[] uf;
    // 양방향 그래프이며 이동 여부만 판단하는 것이므로 union find 이용 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int k = Integer.parseInt(st.nextToken()); // 순서의 길이

        uf = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x,y);
        }

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        for (int i = 0; i < k-1; i++) {
            if (find(nums[i]) != find(nums[i+1])) {
                ans = 0;
            }
        }
        System.out.println(ans);
    }

    private static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    private static int find(int x) {
        if (uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf[x]);
    }

}

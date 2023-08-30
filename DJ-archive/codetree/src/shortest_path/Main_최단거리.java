package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.codetree.ai/missions/8/problems/shortest-distance?&utm_source=clipboard&utm_medium=text

public class Main_최단거리 {
    // ** 그래프가 두개 이상일 때 최솟값 처리하는 것을 계속 잊거나 헷갈려한다. (하나로 처리 가능한지, 아닌지 판별하기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 (해당 문제는 별도의 그래프를 따로 두거나 초기값 세팅도 필요없는 문제였다..)
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.println(sb);
    }

}

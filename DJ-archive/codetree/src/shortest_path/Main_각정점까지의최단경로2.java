package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.codetree.ai/missions/8/problems/shortest-path-to-each-vertex-2?&utm_source=clipboard&utm_medium=text
public class Main_각정점까지의최단경로2 {

    // 플로이드 복습
    // 정점의 수 100개, 간선의 수는 정점의 수에 비해 많음. (100,000개)
    // 따라서 모든 정점의 최소 거리를 다익스트라로 구할 경우 log(V*ElogV)의 E가 V^2이 되어 O(V^3)의 플로이드가 더 효율적이다.
    // 또한 플로이드는 구현이 다익스트라보다 더 쉬워서 플로이드로 구현함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        // 초기값 세팅
        final int MAX = 900_000_000; // 더했을 때 범위 안늘어나도록 조심
        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i==j) graph[i][j] = 0;
                else graph[i][j] = MAX;
            }
        }

        // 바로 갈 수 있는 간선 비용 저장
        // 주의! 같은 경로의 간선이 또 추가될 수 있으므로 최솟값 저장할 것
        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            if (graph[edge.x][edge.y] != MAX) {
                graph[edge.x][edge.y] = Math.min(graph[edge.x][edge.y], edge.v);
            } else graph[edge.x][edge.y] = edge.v;
        }

        // 플로이드
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        // 정답 출력
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == MAX) {
                    graph[i][j] = -1; // 불가능한 경우 -1 cnffur
                }
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }



    }

    // 정점 객체
    private static class Edge {
        int x;
        int y;
        int v;

        public Edge(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}

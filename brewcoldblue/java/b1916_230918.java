import java.util.*;

 class Main {

    static class Node {
        //정점, weight
        int v;
        long w;
        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

    }

    static final long INF = Long.MAX_VALUE;
    static int V, E;
    static List<Node>[] adjList; //인접리스트
    static long[] dist; //최단길이를 저장할 배열
    static int[] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        adjList = new ArrayList[V+1];
        for(int i=1; i<V+1; i++) adjList[i] = new ArrayList<>();
        dist = new long[V+1];
        path = new int[V+1];

        Arrays.fill(dist, INF);

        for(int i=0; i<E; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            long W = sc.nextLong();
            //유향그래프

            adjList[A].add(new Node(B, W)); //A라는 점은 B에 연결되어 있고 W라는 가중치를 가짐
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        dijkstra(start);

        //비용
        System.out.println(dist[end]-dist[start]);
    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[V+1];
        dist[start] = 0; //시작 노드에서 시작 노드까지의 거리는 0
        path[start] = 0;
        //사용하지 않는 인덱스
        dist[0] = -1;
        path[0] = -1;
        for(int i=1; i<V; i++) {
            long min = INF;
            int idx = -1;

            //선택하지 않은 정점 중 dist가 가장 짧은 것을 고름
            for(int j=1; j<V+1; j++) {
                if(!visited[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }
            if(idx == -1) break; //선택할 수 없으면 멈추ㅁ
            visited[idx] = true; //선택
            //갱신할 수 있으면 갱신
            for(int j=0; j<adjList[idx].size(); j++) {
                Node cur = adjList[idx].get(j);

                //방문하지 않았고, 연결도 되었고,
                //이미 가지고 있는 값보다 더 작은 값이 있다면 갱신
                if(!visited[cur.v] && dist[cur.v] > dist[idx] + cur.w) {
                    //프림은 그 간선이 나보다 작으면 그냥 갱신하는데, 다익스트라는 시작정점으로부터의 최단경로를 모두 고려 (여기까지 온 값 + 앞으로 갈 값)
                    dist[cur.v] = dist[idx] + cur.w;
                    path[cur.v] = idx;
                }
            }
        }

    }


}

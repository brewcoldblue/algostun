import java.util.*;

public class b9344_230905 {
    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    static int N;
    static List<Edge>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            N = sc.nextInt();
            int M = sc.nextInt();
            int p = sc.nextInt() - 1;
            int q = sc.nextInt() - 1;
            
            adjList = new ArrayList[N];
            for (int i = 0; i < N; i++) adjList[i] = new ArrayList<>();
            
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                int w = sc.nextInt();
                adjList[u].add(new Edge(u, v, w));
                adjList[v].add(new Edge(v, u, w));
            }
            
            int before = prim();
            adjList[p].add(new Edge(p, q, 0));
            adjList[q].add(new Edge(q, p, 0));
            int after = prim();
            
            System.out.println(before == after ? "YES" : "NO");
        }
    }

    static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        boolean[] visited = new boolean[N];
        pq.add(new Edge(-1, 0, 0));
        
        int cost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.dest]) continue;

            visited[curr.dest] = true;
            cost += curr.weight;

            for (Edge edge : adjList[curr.dest]) {
                if (!visited[edge.dest]) pq.add(edge);
            }
        }
        return cost;
    }
}

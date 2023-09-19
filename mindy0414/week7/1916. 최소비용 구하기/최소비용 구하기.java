import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] l;
    static int[] dp;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        l = new ArrayList[n + 1];
        dp = new int[n + 1];
        chk = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) l[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            l[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);

        q.add(new Node(start, 0));
        dp[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int to = node.to;
            if (chk[to]) continue;

            chk[node.to] = true;
            for (Node next : l[to]) {
                if (dp[next.to] >= dp[to] + next.cost) {
                    dp[next.to] = dp[to] + next.cost;
                    q.add(new Node(next.to, dp[next.to]));
                }
            }
        }
        System.out.println(dp[destination]);
    }
}

class Node implements Comparable<Node>{
    int to, cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}


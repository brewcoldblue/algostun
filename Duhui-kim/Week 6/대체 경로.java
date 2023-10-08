import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] lists = new LinkedList[N+1];
		
		for(int i=1; i<=N; i++) {
			lists[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lists[a].add(b);
			lists[b].add(a);
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		final int BIG_VALUE = 1000_000_000;
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(i == S || i == E) {
				sb.append("-1");
				if(i != N) sb.append("\n");
				continue;
			}
			
			queue.offer(new int[] {S, 0});
			int[] check = new int[N+1];
			Arrays.fill(check, BIG_VALUE);
			check[S] = 1;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				for(int nxt : lists[cur[0]]) {
					if(nxt == i) continue;
					if(check[nxt] <= check[cur[0]] + 1) continue;
					
					check[nxt] = check[cur[0]] + 1;
					queue.offer(new int[]{nxt, check[nxt]});
				}
			}
			if(check[E] == BIG_VALUE) {
				sb.append("-1");
			} else {
				sb.append(check[E]);
			}
			if(i != N) sb.append("\n");
		}
		System.out.println(sb);
	}
}
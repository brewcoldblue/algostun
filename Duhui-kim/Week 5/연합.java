import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = true;
		}
		
		int[] visited = new int[N+1];
		
		int count = 1;
		
		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);

				while (!queue.isEmpty()) {
					int currentNode = queue.poll();
					visited[currentNode] = count;

					for (int nextNode = 1; nextNode <= N; nextNode++) {
						if (map[currentNode][nextNode] &&
							map[nextNode][currentNode] &&
							visited[nextNode] == 0) {
							queue.add(nextNode);
						}
					}
				}
				count++;
			}
		}

		System.out.println(count - 1);		
	}
}
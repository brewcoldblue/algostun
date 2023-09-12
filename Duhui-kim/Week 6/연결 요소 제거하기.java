import java.io.*;
import java.util.*;

class Main {
	public static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N+1][N+1];
		int[][] check = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=1; j<=N; j++) {
				map[i][j] = input[j-1];
			}
		}
		
		int idx = 1;
		int last = 0;
		for(int tc=0; tc<Q; tc++) {
			st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			map[cx][cy] = st.nextToken().charAt(0);
			Set<Integer> set = new HashSet<>();
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] == '.') continue;
					if(check[i][j] > last) continue;
					
					int nums = BFS(map, check, idx, i, j);
					
					if(nums >= K) set.add(idx);
					idx++;
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(set.contains(check[i][j])) {
						map[i][j] = '.';
					}
				}
			}
			
			last = idx - 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static int BFS(char[][] map, int[][] check, int idx, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		
		int seleted = 1;
		queue.offer(new int[] {x,  y});
		check[x][y] = idx;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
				if(check[nx][ny] == idx) continue;
				if(map[nx][ny] != map[x][y]) continue;
				
				queue.offer(new int[] {nx, ny});
				check[nx][ny] = idx;
				seleted++;
			}
		}
		return seleted;
	}
}
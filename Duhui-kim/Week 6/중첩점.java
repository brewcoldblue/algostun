import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		// L R U D
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		Map<String, Integer> direction = new HashMap<>();
		direction.put("L", 0);
		direction.put("R", 1);
		direction.put("U", 2);
		direction.put("D", 3);
	
		Queue<int[]> sero = new LinkedList<>();
		// 가로선 그리기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int[] input = new int[3];
			
			input[0] = Integer.parseInt(st.nextToken());
			input[1] = Integer.parseInt(st.nextToken());
			input[2] = direction.get(st.nextToken());
			
			if(input[2] > 1) {
				sero.offer(input);
			} else {
				while(input[0] > 0 && input[1] > 0 && input[0] <= N && input[1] <= N) {
					map[input[0]][input[1]]++;
					
					input[0] += dx[input[2]];
					input[1] += dy[input[2]];
				}
			}
		}
		
		long answer = 0;
		
		while(!sero.isEmpty()) {
			int[] cur = sero.poll();
			
			while(cur[0] > 0 && cur[1] > 0 && cur[0] <= N && cur[1] <= N) {
				answer += map[cur[0]][cur[1]];
				
				cur[0] += dx[cur[2]];
				cur[1] += dy[cur[2]];
			}
		}
		System.out.println(answer);
	}
}
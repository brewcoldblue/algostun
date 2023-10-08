import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				String nxt = st.nextToken();
				if(nxt.equals("@")) {
					map[i][j] = '@';
				} else if(nxt.equals("#")) {
					map[i][j] = '#';
				}
			}
		}
		
		int[][] bomb = new int[N][N];
		
		int[] dx = {0, -1, 1, 0, 0};
		int[] dy = {0, 0, 0, 1, -1};
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			for(int j=0; j<5; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(map[nx][ny] == '#') continue;
				
				if(map[nx][ny] == '@') bomb[nx][ny] += 2;
				else bomb[nx][ny]++;
			}
		}
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(bomb[i][j] > answer) {
					answer = bomb[i][j];
				}
			}
		}
		System.out.println(answer);
	}
}
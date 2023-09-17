package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_그리드상에서의DFS탐색 {

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1, 0}; // 아래, 오른쪽
    static int[] dy = {0, 1};
    static int N,M;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // board 범위
        // 뱀 x
        // 방문 x

        visited[0][0] = true;
        flag = false;
        dfs(0,0);
        if (flag) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    private static void dfs(int x, int y) {
        if (x == N-1 && y == M-1) {
            flag = true;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        if (0>nx || 0 > ny || nx >= N || ny >= M) return false;
        if (board[nx][ny] == 0 || visited[nx][ny]) {
            return false;
        }
        return true;
    }

}

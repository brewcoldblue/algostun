package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.codetree.ai/missions/2/problems/cross-shape-bomb?&utm_source=clipboard&utm_medium=text
 */
public class Main_십자모양폭발 {

    static int[][] board;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int boomRow = Integer.parseInt(st.nextToken()) - 1;
        int boomCol = Integer.parseInt(st.nextToken()) - 1;
        int power = board[boomRow][boomCol] - 1;

        // 십자가로 폭발시키기
        board[boomRow][boomCol] = 0;
        for (int i = 0; i < 4; i++) {
            int curX = boomRow;
            int curY = boomCol;
            int p = power;

            while (p-- > 0) { // power를 그대로 사용하면, 안됨!
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break; // 경계 조건
                }
                board[nx][ny] = 0;
                curX = nx;
                curY = ny;
            }
        }

        // 떨어뜨리기
        int[][] tmp = new int[n][n];
        for (int col = 0; col < n; col++) { // 열 기준 주의.
            int tmpRowIdx = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    tmp[tmpRowIdx--][col] = board[row][col];
                }
            }
        }

        // 한번 수행하므로 tmp 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }

    }
}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.codetree.ai/missions/2/problems/move-to-larger-adjacent-cell?&utm_source=clipboard&utm_medium=text
 */
public class Main_숫자가더큰인접한곳으로이동 {

    static int[] dx = {-1, 1, 0, 0}; // 우선순위: 상하좌우 순서
    static int[] dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder(); // 정답 기록
        int curX = r;
        int curY = c;
        while (true) {
            int max = board[curX][curY];
            sb.append(max).append(" ");
            // 이렇게 두거나 객체 따로 두는게 편할듯..
            int tScore = 0;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (inRange(nx, ny) && max < board[nx][ny]) {
                    tScore = board[nx][ny];
                    curX = nx;
                    curY = ny;
                    break; // 더 크든말든 상관없고, 하나만 찾으면 된다.
                }
            }

            if (tScore == 0) {
                break;
            }
        }

        System.out.println(sb);

    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

}

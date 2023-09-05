package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.codetree.ai/missions/2/problems/move-to-max-adjacent-cell-simultaneously?&utm_source=clipboard&utm_medium=text
 */
public class Main_숫자가가장큰인접한곳으로동시에이동 {

    static int n, m, t;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 우선순위 적용
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구슬의 현재 위치 count 배열 (현재 위치당 구슬의 수 기록)
        int[][] count = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            count[r][c] = 1;
        }

        // 시간 흐름에 따라 동시에 구슬 이동, 중복 제거, 전체 구슬의 수 갱신
        int totalCnt = m;
        while (t-- > 0) {
            moveAll(count);
            int deletedCnt = deleteDuplicated(count);
            totalCnt -= deletedCnt;
        }
        System.out.println(totalCnt);
    }

    private static int deleteDuplicated(int[][] count) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] > 1) {
                    cnt += count[i][j];
                    count[i][j] = 0;
                }
            }
        }
        return cnt;
    }

    private static void moveAll(int[][] count) {
        // 다음 구슬의 위치 기록할 새 배열 갱신
        int[][] newCount = new int[n][n];

        // 구슬이 있으면, 이동할 위치 탐색 및 이동
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 1) {
                    findMaxVal(i, j, newCount);
                }
            }
        }

        // 이동할 위치 배열을 현재 배열로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[i][j] = newCount[i][j];
            }
        }

    }

    private static void findMaxVal(int i, int j, int[][] newCount) {
        int max = 0;
        int tx = 0;
        int ty = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (max < board[nx][ny]) {
                max = board[nx][ny];
                tx = nx;
                ty = ny;
            }
        }
        newCount[tx][ty]++;
    }
}

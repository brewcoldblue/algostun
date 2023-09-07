package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *https://www.codetree.ai/missions/2/problems/number-of-happy-sequence?&utm_source=clipboard&utm_medium=text
 */
public class Main_행복한수열의갯수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int r = 0; r < N; r++) {
            int max = 0;
            int rowMcnt = 0;
            for (int c = 0; c < N - 1; c++) {
                if (board[r][c] == board[r][c + 1]) {
                    if (rowMcnt == 0) {
                        rowMcnt += 2;
                    } else {
                        rowMcnt++;
                    }
                }

                if ((rowMcnt != 0) && (board[r][c] != board[r][c + 1])) {
                    if (max < rowMcnt) {
                        max = rowMcnt;
                    }
                    rowMcnt = 0;
                }
            }
            if (max < rowMcnt) {
                max = rowMcnt;
            }
            if (max >= M) {
                cnt++;
            }
        }

        for (int c = 0; c < N; c++) {
            int max = 0;
            int colMcnt = 0;
            for (int r = 0; r < N - 1; r++) {
                if (board[r][c] == board[r + 1][c]) {
                    if (colMcnt == 0) {
                        colMcnt += 2;
                    } else {
                        colMcnt++;
                    }
                }

                if ((colMcnt != 0) && (board[r][c] != board[r + 1][c])) {
                    if (max < colMcnt) {
                        max = colMcnt;
                    }
                    colMcnt = 0;
                }
            }
            if (max < colMcnt) {
                max = colMcnt;
            }
            if (max >= M) {
                cnt++;
            }
        }

        if (M == 1) {
            cnt = N + N;
        }

        System.out.println(cnt);
    }
}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.codetree.ai/missions/2/problems/falling-horizontal-block?&utm_source=clipboard&utm_medium=text
 */
public class Main_떨어지는1자블록 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행, 열
        int m = Integer.parseInt(st.nextToken()); // 블록 크기
        int k = Integer.parseInt(st.nextToken()) - 1; // 떨어질 위치 (열)

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cannotGo = -1; // 0-> 막히는 경우가 없을 경우, indexOutOfArray!
        loop:
        for (int row = 0; row < n; row++) {
            for (int col = k; col < m + k; col++) {
                if (board[row][col] != 0) {
                    cannotGo = row; // 여기서 break 안하면 밑도 내려간다.
                    break loop; // continue xxx!
                }
            }
        }

        if (cannotGo == -1) {
            for (int j = k; j < m + k; j++) {
                board[n - 1][j] = 1;
            }
        } else {
            for (int j = k; j < m + k; j++) {
                board[cannotGo - 1][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_삼각형컨베이어벨트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 행은 무조건 3개 행, 열은 3 이상 가능
        int[][] board = new int[3][n];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (t-->0) {
            int tmp1 = board[0][n-1];
            int tmp2 = board[1][n-1];
            int tmp3 = board[2][n-1];

            for (int i = 0; i < 3; i++) {
                for (int j = n-1; j > 0; j--) {
                    board[i][j] = board[i][j-1];
                }
            }
            board[1][0] = tmp1;
            board[2][0] = tmp2;
            board[0][0] = tmp3;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}

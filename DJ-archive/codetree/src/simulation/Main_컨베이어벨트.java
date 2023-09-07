package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_컨베이어벨트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] board = new int[2][n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int cnt = 0; cnt < t; cnt++) {
            int tmp1 = board[0][n-1];
            int tmp2 = board[1][n-1];
            for (int c = n-1; c > 0 ; c--) {
                board[0][c] = board[0][c-1];
            }
            for (int c = n-1; c > 0; c--) {
                board[1][c] = board[1][c-1];
            }
            board[1][0] = tmp1;
            board[0][0] = tmp2;

        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}

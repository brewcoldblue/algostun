package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 격자 안에서 완전 탐색. 기본 개념 문제
 * https://www.codetree.ai/missions/2/problems/best-place-of-33?&utm_source=clipboard&utm_medium=text
 */
public class Main_최고의33위치 {

    static int max;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3*3 완전탐색
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (c + 2 >= N || r + 2 >= N) {
                    continue;
                }

                int score = calculate(r, c);
                if (max < score) {
                    max = score;
                }
            }
        }

        System.out.println(max);

    }

    private static int calculate(int r, int c) {
        int ans = 0;
        for (int i = r; i <= r + 2; i++) {
            for (int j = c; j <= c + 2; j++) {
                ans += board[i][j];
            }
        }

        return ans;
    }

}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.codetree.ai/missions/2/problems/jenga-1d?&utm_source=clipboard&utm_medium=text
 */
public class Main_1차원젠가 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        StringTokenizer st;
        int totalCnt = 0;
        for (int i = 0; i < 2; i++) {
            int[] tmp = new int[n];
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken()) - 1;
            int endIdx = Integer.parseInt(st.nextToken()) - 1;

            // 블록 지우기
            for (int j = startIdx; j <= endIdx; j++) {
                board[j] = 0;
            }

            // tmp 배열에 합치기 (젠가 떨어뜨리기)
            int tmpIdx = 0;
            for (int j = 0; j < n; j++) {
                if (board[j] != 0) {
                    tmp[tmpIdx++] = board[j];
                }
            }
            // tmp 배열을 원배열로 바꾸기
            for (int j = 0; j < n; j++) {
                board[j] = tmp[j];
            }
            // 마지막에 tmpIdx -> totalCnt
            if (i == 1) {
                totalCnt = tmpIdx; // tmpIdx가 +1 된 상태므로 그대로 넣어준다.
            }
        }
        if (totalCnt > 0) {
            System.out.println(totalCnt);
            for (int i = 0; i < totalCnt; i++) {
                System.out.println(board[i]);
            }
        } else {
            System.out.println(totalCnt);
        }

    }
}

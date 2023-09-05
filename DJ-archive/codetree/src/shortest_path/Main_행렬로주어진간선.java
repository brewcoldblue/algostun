package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.codetree.ai/missions/8/problems/edge-given-by-matrix?&utm_source=clipboard&utm_medium=text

public class Main_행렬로주어진간선 {

    // *** 틀렸던 이유 잘 생각해보기! (그래프 관리 별도? 하나로?)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] input = new int[n][n];
        // 입력 및 초기값 세팅!!
        // 자기 자신으로 갈 때 1, 서로 연결되어있을 때 양방향 1
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) input[i][j] = 1;
            }
        }

        // 플로이드로 i에서 j 가는 경로가 있는지 판별 (있으면 1, 없으면 0)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (input[i][k] == 1 && input[k][j] == 1) {
                        input[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }

    }
}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_강력한폭발 {
    static int[][][] bombShapes = {
            {{}},
            {{-2, 0}, {-1, 0}, {0,0}, {1, 0}, {2, 0}},
            {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {0,0}},
            {{-1, -1}, {-1, 1}, {0,0}, {1, -1}, {1, 1}}
    };
    static ArrayList<int[]> bombPos = new ArrayList<>();
    static int n;
    static int[][] bombType;
    static boolean[][] bombed;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] board = new int[n][n];
        bombType = new int[n][n]; // 설치할 폭탄 타입 저장
        bombed = new boolean[n][n]; // 폭탄 폭발시킬 시뮬레이션용 보드 배열


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    bombPos.add(new int[]{i,j});
                }
            }
        }
        simulation(0);
        System.out.println(ans);


    }

    private static void simulation(int cnt) {
        if (cnt == bombPos.size()) {
            if (ans < calculate()) {
                ans = calculate();
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int x = bombPos.get(cnt)[0];
            int y = bombPos.get(cnt)[1];
            bombType[x][y] = i;
            simulation(cnt+1);
            bombType[x][y] = 0;
        }


    }

    private static int calculate() {
        // 폭탄 시뮬레이션 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bombed[i][j] = false;
            }
        }

        // 폭탄 타입별로 폭탄 터뜨리기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombType[i][j] > 0) {
                    bomb(i,j,bombType[i][j]);
                }
            }
        }

        // 폭탄 영역 수 구하기
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombed[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bomb(int r, int c, int type) {
        int[][] bombShape = bombShapes[type];
        for (int i = 0; i < bombShape.length; i++) {
            int nx = r + bombShape[i][0];
            int ny = c + bombShape[i][1];
            if (nx <0 || nx >=n || ny <0 || ny >= n) continue;
            bombed[nx][ny] = true;
        }
    }

}

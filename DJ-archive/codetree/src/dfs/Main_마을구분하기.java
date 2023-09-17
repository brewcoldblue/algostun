package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_마을구분하기 {
    static int[][] board;
    static int totalMCnt;
    static int tmpPplCnt;
    static ArrayList<Integer> pplCntList;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[N][N];
        visited = new boolean[N][N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                board[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        pplCntList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    totalMCnt++;
                    tmpPplCnt = 1; // 주의
                    dfs(i,j);
                    pplCntList.add(tmpPplCnt);
                }
            }
        }
        System.out.println(totalMCnt);
        Collections.sort(pplCntList);
        for (int i = 0; i < pplCntList.size(); i++) {
            System.out.println(pplCntList.get(i));
        }

    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (canGo(nx,ny)) {
                visited[nx][ny] = true;
                tmpPplCnt++;
                dfs(nx,ny); // ** 잊음
            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
        if (board[nx][ny] == 0 || visited[nx][ny]) return false;
        return true;
    }

}

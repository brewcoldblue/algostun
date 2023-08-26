import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] map = new String[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().split("");

        boolean[][] chk = new boolean[N][N];
        int a = 0; // 색약 없음
        int b = 0; // 색약 있음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if(chk[i][j]) continue; // 이미 체크함

                a++;
                Queue<Pos> q = new ArrayDeque<>();
                q.add(new Pos(j, i));
                while(!q.isEmpty()){
                    Pos tmp = q.poll();
                    if(chk[tmp.y][tmp.x]) continue; // 이미 체크함
                    chk[tmp.y][tmp.x] = true;
                    for (int k = 0; k < 4; k++) {
                        if (tmp.x + dx[k] < 0 || tmp.y + dy[k] < 0
                                || tmp.x + dx[k] >= N || tmp.y + dy[k] >= N)
                            continue;
                        if(!chk[tmp.y + dy[k]][tmp.x + dx[k]] && map[tmp.y + dy[k]][tmp.x + dx[k]].equals(map[i][j]))
                            q.add(new Pos(tmp.x + dx[k], tmp.y + dy[k]));
                    }
                }

            }
        }

        chk = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if(chk[i][j]) continue; // 이미 체크함

                b++;
                Queue<Pos> q = new ArrayDeque<>();
                q.add(new Pos(j, i));
                while(!q.isEmpty()){
                    Pos tmp = q.poll();
                    if(chk[tmp.y][tmp.x]) continue; // 이미 체크함
                    chk[tmp.y][tmp.x] = true;
                    for (int k = 0; k < 4; k++) {
                        if (tmp.x + dx[k] < 0 || tmp.y + dy[k] < 0
                                || tmp.x + dx[k] >= N || tmp.y + dy[k] >= N)
                            continue;
                        if((!chk[tmp.y + dy[k]][tmp.x + dx[k]]) &&
                                (map[tmp.y + dy[k]][tmp.x + dx[k]].equals(map[i][j])
                                || ((map[i][j].equals("R") || map[i][j].equals("G"))
                                        && (map[tmp.y + dy[k]][tmp.x + dx[k]].equals("R")
                                            || map[tmp.y + dy[k]][tmp.x + dx[k]].equals("G")))))
                            q.add(new Pos(tmp.x + dx[k], tmp.y + dy[k]));
                    }
                }

            }
        }

        System.out.println(a+" "+b);

    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
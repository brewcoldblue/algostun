import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        out:
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            String[][] map = new String[H][W];
            Pos start = null;
            ArrayList<Pos> bul = new ArrayList<>();
            for (int h = 0; h < H; h++) {
                map[h] = br.readLine().split("");
                for (int w = 0; w < W; w++) {
                    if(map[h][w].equals("@")) start = new Pos(w, h, "@");
                    else if(map[h][w].equals("*")) bul.add(new Pos(w, h, "*"));
                }
            }

            int ans = 0;
            Queue<Pos> q = new ArrayDeque<>(); // x, y
            q.add(start);
            q.addAll(bul);
            while(!q.isEmpty()){
                ans++;
                int qSize = q.size();
                for (int i = 0; i < qSize; i++) {
                    Pos tmp = q.poll();
                    if(tmp.s.equals("@") && map[tmp.y][tmp.x].equals("@")) {
                        for (int j = 0; j < 4; j++) {
                            int nx = tmp.x + dx[j];
                            int ny = tmp.y + dy[j];
                            if(nx < 0 || nx >= W || ny < 0 || ny >= H) {
                                System.out.println(ans);
                                continue out;
                            }

                            if(map[ny][nx].equals(".")) {
                                map[ny][nx] = "@";
                                q.add(new Pos(nx, ny, "@"));
                            }
                        }
                    }
                    else if(tmp.s.equals("*")){
                        for (int j = 0; j < 4; j++) {
                            int nx = tmp.x + dx[j];
                            int ny = tmp.y + dy[j];
                            if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;

                            if(map[ny][nx].equals(".") || map[ny][nx].equals("@")) {
                                map[ny][nx] = "*";
                                q.add(new Pos(nx, ny, "*"));
                            }
                        }

                    }
                }
            }
            System.out.println("IMPOSSIBLE");
        }
    }
    static class Pos {
        int x; int y; String s;
        Pos(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
}
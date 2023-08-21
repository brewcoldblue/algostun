import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

        for (int i = 0; i < N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < 4; j++) hs.add(Integer.parseInt(st.nextToken()));
            hm.put(tmp, hs);

            int like = -1;
            int bin = -1;
            int tmpX = -1; int tmpY = -1;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if(map[y][x] != 0) continue;
                    int tmpLike = 0;
                    int tmpBin = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                        if(hm.get(tmp).contains(map[ny][nx])) tmpLike++;
                        else if (map[ny][nx] == 0) tmpBin++;
                    }
                    if(tmpLike > like) {
                        like = tmpLike;
                        tmpX = x; tmpY = y;
                        bin = tmpBin;
                    }
                    else if(tmpLike == like && bin < tmpBin) {
                        tmpX = x; tmpY = y;
                        bin = tmpBin;
                    }
                }
            }
            map[tmpY][tmpX] = tmp;
        }

        int ans = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int tmp = map[y][x];
                int like = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if(hm.get(tmp).contains(map[ny][nx])) like++;
                }
                if(like == 1) ans += 1;
                else if(like == 2) ans += 10;
                else if(like == 3) ans += 100;
                else if(like == 4) ans += 1000;
            }
        }
        System.out.println(ans);
    }
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
}
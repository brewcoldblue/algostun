import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        String[][] map = new String[H][W];
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                if (map[i][j].equals("C")){
                    al.add(new int[]{j, i});
                    map[i][j] = ".";
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(al.get(0));
        map[al.get(0)[1]][al.get(0)[0]] = "-1";
        out:
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int a = 1;
                while(tmp[0] + dx[i]*a >= 0 && tmp[1] + dy[i]*a >= 0
                        && tmp[0] + dx[i]*a < W && tmp[1] + dy[i]*a < H
                        && !map[tmp[1]+dy[i]*a][tmp[0]+dx[i]*a].equals("*")) {
                    if(map[tmp[1]+dy[i]*a][tmp[0]+dx[i]*a].equals(".")){
                        map[tmp[1]+dy[i]*a][tmp[0]+dx[i]*a]
                                = Integer.toString(Integer.parseInt(map[tmp[1]][tmp[0]]) + 1);
                        q.add(new int[]{tmp[0]+dx[i]*a, tmp[1]+dy[i]*a});
                    }
                    if(tmp[0]+dx[i]*a == al.get(1)[0] && tmp[1]+dy[i]*a == al.get(1)[1]) break out;
                    a++;
                }
            }
        }
        System.out.println(map[al.get(1)[1]][al.get(1)[0]]);

    }
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
}
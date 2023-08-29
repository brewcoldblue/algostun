import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(br.readLine());
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int[][] map = new int[n + 1][n + 1];
        int[][] order = new int[n + 1][n + 1];
        int[][] like = new int[(n * n) + 1][5];

        for (int i = 1; i <= n * n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; ++j) {
                like[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nextY, nextX;
        for (int s = 1; s <= n * n; ++s) {
            int student = like[s][0];
            int preferredY = 0;
            int preferredX = 0;
            int maxLikeCount = 0;
            int maxEmptyCount = 0;

            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (map[i][j] != 0) {
                        continue;
                    }

                    if (preferredY == 0 && preferredX == 0) {
                        preferredY = i;
                        preferredX = j;
                    }

                    int likeCount = 0;
                    int emptyCount = 0;
                    boolean check = false;

                    for (int k = 0; k < 4; ++k) {
                        nextY = i + dy[k];
                        nextX = j + dx[k];

                        if (nextY < 1 || nextX < 1 || nextY > n || nextX > n) {
                            continue;
                        }

                        if (map[nextY][nextX] == 0) {
                            ++emptyCount;
                        } else {
                            for (int l = 1; l <= 4; ++l) {
                                if (map[nextY][nextX] == like[s][l]) {
                                    ++likeCount;
                                    break;
                                }
                            }
                        }
                    }

                    if (likeCount > maxLikeCount) {
                        check = true;
                    } else if (likeCount < maxLikeCount) {
                        continue;
                    }

                    if (emptyCount > maxEmptyCount) {
                        check = true;
                    } else if (!check && emptyCount < maxEmptyCount) {
                        continue;
                    }

                    if (i < preferredY || preferredY == 0) {
                        check = true;
                    } else if (!check && i > preferredY) {
                        continue;
                    }

                    if (j < preferredX || preferredX == 0) {
                        check = true;
                    }

                    if (check) {
                        maxLikeCount = likeCount;
                        maxEmptyCount = emptyCount;
                        preferredY = i;
                        preferredX = j;
                    }
                }
            }

            order[preferredY][preferredX] = s;
            map[preferredY][preferredX] = student;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int happiness = 1;

                for (int k = 0; k < 4; ++k) {
                    nextY = i + dy[k];
                    nextX = j + dx[k];

                    if (nextY < 1 || nextX < 1 || nextY > n || nextX > n) {
                        continue;
                    }

                    for (int l = 1; l <= 4; ++l) {
                        if (map[nextY][nextX] == like[order[i][j]][l]) {
                            happiness *= 10;
                            break;
                        }
                    }
                }

                ans += (happiness / 10);
            }
        }

        System.out.println(ans);
    }
}

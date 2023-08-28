import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_14889_스타트와링크 {
    static int N;
    static int[][] scores;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N+1][N+1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeam(1, 0, new boolean[N+1]);
        System.out.println(min);
    }

    private static void divideTeam(int start, int k, boolean[] isUsed) {
        if (k == N/2) {

            int startScore = 0;
            int linkScore = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = i+1; j <= N; j++) {
                    // 스타트팀
                    if (isUsed[i] && isUsed[j]) {
                        startScore += scores[i][j];
                        startScore += scores[j][i];
                    }
                    // 링크팀
                    if (!isUsed[i] && !isUsed[j]) {
                        linkScore += scores[i][j];
                        linkScore += scores[j][i];
                    }

                }
            }
            int diff = Math.abs(startScore-linkScore);
            if(min > diff) {
                min = diff;
            }
        }

        for (int i = start; i <= N; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            divideTeam(i, k+1, isUsed);
            isUsed[i] = false;
        }
    }

}

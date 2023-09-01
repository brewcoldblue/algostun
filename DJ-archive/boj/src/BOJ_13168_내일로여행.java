import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_13168_내일로여행 {

    /*
     * N이 100으로 작고, 여행 가능한 모든 도시 <-> 도시의 최소 비용을 구해야하므로 플로이드 워셜 적합함
     * 모든 정점 경로 주어짐 (시작점 == 끝점)
     * 내일로 티켓을 끊었을 경우와 끊지 않았을 경우의 dist 그래프 별도로 생성 후 플로이드 워셜
     * - 50%할인의 경우 짝수임을 보장하지 않으므로 2배해서 저장
     * - 도시 중복해서 입력될 수 있음 (최소값 처리 주의!)
     * - 내일로 티켓 가격 마지막에 더래주어야 함!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 수
        int R = Integer.parseInt(st.nextToken()); // 내일로 티켓 가격
        st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> cityMap = new HashMap<>();

        // 도시 인덱스화 및 중복된 도시 처리 (map)
        int mapIdx = 1;
        for (int i = 0; i < N; i++) {
            cityMap.putIfAbsent(st.nextToken(), mapIdx++);
        }

        int M = Integer.parseInt(br.readLine()); // 여행할 도시
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> cityPaths = new ArrayList<>(); // 여행할 도시 경로 저장
        for (int i = 0; i < M; i++) {
            cityPaths.add(cityMap.get(st.nextToken()));
        }

        // 초기 세팅
        int K = Integer.parseInt(br.readLine()); // 교통수단 수
        int[][] dist1 = new int[mapIdx + 1][mapIdx + 1]; // 내일로 x
        int[][] dist2 = new int[mapIdx + 1][mapIdx + 1]; // 내일로 o
        final int MAX = 900_000_000; // ** 9억으로 했었는데, 전체 경로 다 더하면서 초과되었었음.
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    dist1[i][j] = 0;
                    dist2[i][j] = 0;
                } else {
                    dist1[i][j] = MAX;
                    dist2[i][j] = MAX;
                }
            }
        }

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int from = cityMap.get(st.nextToken());
            int to = cityMap.get(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 오반데.... 여기서 틀림..
            switch (type) {
                case "Mugunghwa": // 무료
                case "ITX-Saemaeul":
                case "ITX-Cheongchun": // 양쪽 다 넣어줘야함!!
                    dist1[from][to] = Math.min(2*cost,dist1[from][to]);
                    dist1[to][from] = Math.min(2*cost,dist1[to][from]);
                    dist2[from][to] = Math.min(0,dist2[from][to]);
                    dist2[to][from] = Math.min(0,dist2[to][from]);
                    break;
                case "S-Train": // 50%
                case "V-Train":
                    dist1[from][to] = Math.min(2*cost,dist1[from][to]);
                    dist1[to][from] = Math.min(2*cost,dist1[to][from]);
                    dist2[from][to] = Math.min(cost,dist2[from][to]);
                    dist2[to][from] = Math.min(cost,dist2[to][from]);
                    break;
                default: // 나머지
                    dist1[from][to] = Math.min(2*cost,dist1[from][to]);
                    dist1[to][from] = Math.min(2*cost,dist1[to][from]);
                    dist2[from][to] = Math.min(2*cost,dist2[from][to]);
                    dist2[to][from] = Math.min(2*cost,dist2[to][from]);
            }

        }

        // 플로이드
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (dist1[i][j] > dist1[i][k] + dist1[k][j]) {
                        dist1[i][j] = dist1[i][k] + dist1[k][j];
                    }
                    if (dist2[i][j] > dist2[i][k] + dist2[k][j]) {
                        dist2[i][j] = dist2[i][k] + dist2[k][j];
                    }
                }
            }
        }

        // 비용 비교 (long 주의)
        long cost1 = 0;
        long cost2 = 0;
        for (int i = 0; i < cityPaths.size()-1; i++) {
            int from = cityPaths.get(i);
            int to = cityPaths.get(i+1);
            cost1 += dist1[from][to];
            cost2 += dist2[from][to];
        }
        cost2 += (R* 2L); // **내일로 티켓 가격 더해주기

        // 정답 출력
        if (cost1 > cost2) { // 내일로 티켓이 더 이득인 경우
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}

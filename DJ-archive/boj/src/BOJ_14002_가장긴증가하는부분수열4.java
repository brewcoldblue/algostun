import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {
    // j < i, arr[j] < arr[i]
    // ** 모두 초기값 1 (자기 자신이 수열인 경우)
    // d[i] = i번째 숫자까지 왔을 때, 가장 긴 부분수열의 길이
    // 왔던 길을 기록해야 함! -> 별도 배열 생성 (path)
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // d[i] = i번째 숫자까지 왔을 때, 가장 긴 부분수열의 길이
        int[] d = new int[N+1];
        Arrays.fill(d, 1);

        // 그 전 숫자의 순서 기록 (경로 추적 위함)
        int[] path = new int[N+1];
        Arrays.fill(path, -1);

        // d[i] 생성 및 path 기록
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j]+1);
                    if (d[i] == d[j]+1) path[i] = j;
                }
            }
        }

        // 최대 증가 부분수열의 길이 구하기
        int max = 0;
        int lastIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (max < d[i]) {
                max = d[i];
                lastIdx = i;
            }
        }
        System.out.println(max);

        // 경로 꺼내기
//        System.out.println(Arrays.toString(path));
        printPath(lastIdx, path);

    }

    private static void printPath(int idx, int[] path) {
        if (path[idx] == -1) {
            System.out.print(arr[idx]+" ");
            return;
        }
        printPath(path[idx], path);
        System.out.print(arr[idx]+" ");
    }
}

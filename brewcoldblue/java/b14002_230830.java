import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N]; //i번째 원소를 마지막으로 하는 LIS의 길이
        int[] trace = new int[N]; //추적용 배열
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(trace, -1); 
        int maxidx = 0;
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1; //길이는 1부터 시작함
            for (int j = 0; j < i; j++) {
							//i번째 원소보다 j번째가 작고, LIS의 길이가 더 짧으면 갱신함
							//현재 원소가 이전 원소보다 크면 갱신하는거임
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; //LIS의 길이를 갱신함
                    trace[i] = j; //i번째 바로 전에 오는 원소의 idx
                }
            }
            if (dp[maxidx] < dp[i]) { //가장 큰 값을 찾아서 인덱스 저장함
                maxidx = i; //LIS의 마지막 원소의 인덱스가 됨
            }
        }
        
        Stack<Integer> result = new Stack<>();
        while (maxidx != -1) {
            result.add(arr[maxidx]);
            maxidx = trace[maxidx];
        }
        
        System.out.println(result.size());
        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}

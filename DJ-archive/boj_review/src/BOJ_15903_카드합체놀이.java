import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903_카드합체놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        // 숫자 범위 주의
        long sum = 0;
        while (!pq.isEmpty() && --m >= 0) {
            long first = pq.poll();
            long second = pq.poll();
            long tmp = first + second;
            pq.add(tmp);
            pq.add(tmp);
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);

    }

}

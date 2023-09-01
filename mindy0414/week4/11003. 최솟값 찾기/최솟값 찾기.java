import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.peekLast()[0] > num) dq.pollLast();

            dq.offer(new int[] {num,i});
            while(dq.peek()[1] < i-L+1) dq.poll();
            bw.write(dq.peek()[0]+" ");
        }

        bw.close();
    }
}
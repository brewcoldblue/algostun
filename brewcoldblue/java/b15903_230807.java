import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for(int i=0; i<N; i++) {
			pq.add(sc.nextLong());
		}

		for(int i=0; i<M; i++) {
			long first = pq.poll();
			long second = pq.poll();

			pq.add(first+second);
			pq.add(first+second);
		}

		long answer = 0;
		while(!pq.isEmpty()) answer += pq.poll();
		

		System.out.println(answer);
	}
}
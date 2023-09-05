import java.io.*;
import java.util.*;

class Main {
	public static class Fruit {
		int fullness;
		int count;
		
		public Fruit(int count, int fullness) {
			this.count = count;
			this.fullness = fullness;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Fruit> fruits = new PriorityQueue<>((o1, o2) -> {
			return o2.fullness - o1.fullness;
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			Fruit fruit = new Fruit(p, c/p);
			fruits.offer(fruit);
		}
		long answer = 0;
		while(K > 0) {
			if(fruits.isEmpty()) break;
			
			Fruit f = fruits.poll();
			
			if(f.count <= K) {
				answer += f.count * f.fullness;
				K -= f.count;
			} else {
				answer += K * f.fullness;
				K = 0;
			}
		}
		System.out.println(answer);
	}
}
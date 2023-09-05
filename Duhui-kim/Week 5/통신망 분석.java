import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] lists = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			lists[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lists[a].add(b);
			lists[b].add(a);
		}
		
		int[] check = new int[N+1];
		
		Queue<Integer> queue = new LinkedList();
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(check[i] != 0) continue;
			cnt++;
			
			check[i] = cnt;
			queue.offer(i);
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				for(int nxt : lists[cur]) {
					if(check[nxt] == 0) {
						check[nxt] = cnt;
						queue.offer(nxt);
					}
				}
			}
		}
		
		double[][] arr = new double[cnt][4];
		
		for(int i=1; i<=N; i++) {
			arr[check[i]-1][0] += lists[i].size();
			arr[check[i]-1][1]++;
			arr[check[i]-1][3] = check[i];
			
			if(arr[check[i]-1][2] == 0) {
				arr[check[i]-1][2] = i;
			}
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			double ratio1 = o1[0] / o1[1];
			double ratio2 = o2[0] / o2[1];

			if (Math.abs(ratio1 - ratio2) < 1e-9) {
				if (o1[1] == o2[1]) {
					return Double.compare(o1[2], o2[2]);
				}
				return Double.compare(o1[1], o2[1]);
			}
			return Double.compare(ratio2, ratio1);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if((int) arr[0][3] != check[i]) continue;
			sb.append(i + " ");
		}
		System.out.println(sb);	
	}
}
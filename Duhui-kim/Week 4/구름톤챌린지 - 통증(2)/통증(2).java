import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] pain = new int[N+1];
		
		Arrays.fill(pain, -1);
		pain[0] = 0;
		
		for(int i=A; i<=N; i++) {
			if(pain[i-A] < 0) continue;
			pain[i] = pain[i-A] + 1;
		}
		
		for(int i=B; i<=N; i++) {
			if(pain[i-B] < 0) continue;

			if(pain[i] < 0) {
				pain[i] = pain[i-B] + 1;
			} else {
				pain[i] = pain[i-B] + 1 < pain[i] ? pain[i-B] + 1 : pain[i];
			}
		}
		
		System.out.println(pain[N]);
	}
}
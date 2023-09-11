import java.util.LinkedList;
import java.util.Queue;

public class c0002_230911 {
	public static void main(String[] args) {
		// int[] queue = {2, 1, 3, 1, 2, 1};
		int[] queue = {3, 3, 3, 3, 3, 3};
		// int[] queue = {1, 2, 3};
		
		int[] count = {0, 0, 0, 0}; //개수
		int[] answer = {0, 0, 0, 0}; //추가한 횟수
		Queue<Integer> Q = new LinkedList<>();

		for(int item : queue) {
			Q.offer(item);
			count[item]++;
		}

		int min = 0;
		while(!check(count[1], count[2], count[3])) {
			int polled = Q.poll();
			count[polled]--;
			min = count[3] < 
						(count[1] < count[2] ? 1 : 2)
							? 3
							: (count[1] < count[2] ? 1 : 2);
			Q.offer(min);
			count[min]++;
			answer[min]++;
		}
		System.out.println(answer[1]+" "+answer[2]+" "+answer[3]);
	}

	static boolean check(int a, int b, int c) {
		if(a == 0 || b == 0 || c == 0) return false;
		if(a != b || a != c) return false;
		else return true;
	}
}
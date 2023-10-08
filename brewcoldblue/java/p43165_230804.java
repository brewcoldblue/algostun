class Solution {
	public static int solution(int[] numbers, int target) {
			int answer = 0;
			int N = numbers.length;
			for(int i=0; i<(1<<N); i++) {
		int tmp = 0;
					for(int j=0; j<N; j++) {
							if((i & (1<<j)) != 0) tmp += (-1)*numbers[j];
							else tmp +=numbers[j];
					}
					if(tmp == target) answer++;
			}
			return answer;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1, 1, 1, 1, 1};
		int[] arr2 = new int[] {4, 1, 2, 1};
		System.out.println(solution(arr, 3));
		System.out.println(solution(arr2, 2));
	}
}
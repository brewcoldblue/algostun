import java.util.Arrays;

public class Solution_최솟값만들기 {

    class Solution {

        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.parallelSort(A);
            Arrays.parallelSort(B);

            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[A.length - i -1];
            }
            return answer;
        }
    }
}

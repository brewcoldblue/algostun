import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;

        // 정렬
        Arrays.sort(people);

        int idx = 0;
        // 가장 큰 것과 가장 작은 것 매칭
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                answer++;
                idx++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
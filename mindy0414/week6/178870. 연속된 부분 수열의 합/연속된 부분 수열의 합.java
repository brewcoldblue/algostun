import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int l = 0;
        int r = -1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]-o1[0] == o2[1]-o2[0])
                    return o1[0] - o2[0];
                else return (o1[1]-o1[0]) - (o2[1]-o2[0]);
            }
        });
        
        int sum = 0;
        while(r < sequence.length) {
            if(sum < k) { 
                r++; 
                if(r >= sequence.length) break;
                sum += sequence[r]; 
            }
            else if(sum > k) { sum -= sequence[l]; l++; }
            else if(sum == k) { 
                pq.add(new int[] {l, r});
                sum -= sequence[l]; l++; 
            }
        }
        return pq.poll();
    }
}
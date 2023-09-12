public class Solution_C2 {

    public static void main(String[] args) {
        int[] queue = new int[] {2,1,3,1,2,1};
        int queueLen = queue.length;
        int[] result = solution(queue, queueLen);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] solution(int[] queue, int queueLen) {
        int[] result = new int[3];
        // 각 원소 갯수 배열
        int[] cnt = new int[4];
        for (int i = 0; i < queueLen; i++) {
            cnt[queue[i]]++;
        }

        if (findMax(queueLen, cnt)) {
            return result;
        }

        for (int i = 0; i < queueLen; i++) {
            int target = queue[i];
            //  가장 적은 원소에 채워주기
            int min = queueLen/3 + 3;
            int minIdx = 0;
            for (int j = 1; j <= 3; j++) {
                if (min > cnt[j]) {
                    minIdx = j;
                    min = cnt[j];
                }
            }
            cnt[target]--;
            cnt[minIdx]++;
            result[minIdx-1]++;

            if (findMax(queueLen, cnt)) {
                break;
            }
        }


        return result;
    }

    private static boolean findMax(int queueLen, int[] cnt) {
        int max = 0;
        for (int j = 1; j <= 3; j++) {
            if (cnt[j] > max) max = cnt[j];
        }
        if (max == queueLen / 3) {
            return true;
        }
        return false;
    }

}

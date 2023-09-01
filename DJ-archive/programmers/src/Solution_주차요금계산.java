import java.util.*;
class Solution_주차요금계산 {
    
    public static int formula(int t, int[] fees) {
        if (t <= fees[0]) return fees[1];
        int q = (t - fees[0] + fees[2] - 1) / fees[2];
        return fees[1] + q * fees[3];
    }

    public static int s2t(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] cnt = new int[10000];
        int[] stored = new int[10000];
        Arrays.fill(stored, -1);

        for (String r : records) {
            String[] parts = r.split(" ");
            String s = parts[0];
            int num = Integer.parseInt(parts[1]);
            String state = parts[2];
            int t = s2t(s);

            if (state.equals("IN")) {
                stored[num] = t;
            } else {
                cnt[num] += t - stored[num];
                stored[num] = -1;
            }
        }

        for (int i = 0; i < 10000; i++) {
            if (stored[i] != -1) {
                cnt[i] += s2t("23:59") - stored[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int x : cnt) {
            if (x != 0) {
                result.add(formula(x, fees));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

}
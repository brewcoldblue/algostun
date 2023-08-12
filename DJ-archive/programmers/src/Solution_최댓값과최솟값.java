public class Solution_최댓값과최솟값 {

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(Solution(s));
    }

    private static String Solution(String s) {
        StringBuilder answer = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String ss : s.split(" ")) {
            int i = Integer.parseInt(ss);
            if (i > max) max = i;
            if (i < min) min = i;
        }
        answer.append(min).append(" ").append(max);
        return answer.toString();
    }

}

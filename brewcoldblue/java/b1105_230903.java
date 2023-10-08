import java.util.Scanner;

public class b1105_230903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //자릿수끼리 비교하려고 문자열로 받음
        String L = sc.next();
        String R = sc.next();

        int result = 0;

        // 두 숫자의 자릿수가 같은지 확인
        // 8이 한개도 없는 어떤 수가 무조건 있을거고 그럼0임
        if (L.length() == R.length()) {
            // 길이가 같다면, 각 자릿수를 확인
            for (int i = 0; i < L.length(); i++) {
                // 현재 자릿수의 숫자가 다르면 break
                if (L.charAt(i) != R.charAt(i)) break;   
                // 현재 자릿수가 8이면 결과 +1
                if (L.charAt(i) == '8') result++;
            }
        }
        System.out.println(result);
    }
}

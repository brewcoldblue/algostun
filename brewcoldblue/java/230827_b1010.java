import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt(); // 서쪽 사이트
            int M = scanner.nextInt(); // 동쪽 사이트
            System.out.println(combi(M, N));
        }
    }

    public static long combi(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        if (r == 1) {
            return n;
        }
        // n-r이 r보다 작을 경우, 계산을 줄이기 위해 r을 n-r로 교체
        if (n - r < r) {
            r = n - r;
        }

        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= n--;
            result /= i;
        }
        return result;
    }
}

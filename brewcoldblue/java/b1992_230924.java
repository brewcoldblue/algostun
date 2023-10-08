import java.util.Scanner;

 class Main {

    private static char[][] image;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        image = new char[N][N];
        for (int i = 0; i < N; i++) {
            image[i] = sc.next().toCharArray();
        }
        System.out.println(compress(0, 0, N));
        sc.close();
    }

    private static String compress(int y, int x, int n) {
        if (n == 1) {
            return Character.toString(image[y][x]);
        }

        boolean uniform = true;
        char check = image[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (check != image[i][j]) {
                    uniform = false;
                    break;
                }
            }
            if (!uniform) break;
        }

        if (uniform) {
            return Character.toString(check);
        } else {
            int half = n / 2;
            return "(" + compress(y, x, half) + compress(y, x + half, half)
                    + compress(y + half, x, half) + compress(y + half, x + half, half) + ")";
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

 class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        System.out.println(findFraction(X));
    }

    public static String findFraction(int X) {
        int line = 1;  // 해당 숫자가 속한 지그재그 라인

        while (X > line) {
            X -= line;
            line += 1;
        }

        int up, down;

        // line이 짝수일 경우 (왼쪽 위에서 오른쪽 아래로)
        if (line % 2 == 0) {
            up = X;
            down = line - X + 1;
        }
        // line이 홀수일 경우 (오른쪽 아래에서 왼쪽 위로)
        else {
            up = line - X + 1;
            down = X;
        }

        return up + "/" + down;
    }
}

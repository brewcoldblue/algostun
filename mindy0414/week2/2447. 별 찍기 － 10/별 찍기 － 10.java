import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) arr[i][j]  = " ";
        }
        recur(arr, 0, 0, N);

        for (String[] strings : arr) {
            for (String string : strings)
                bw.write(string + "");
            bw.write("\n");
        }
        bw.close();
    }
    static void recur(String[][] arr, int x, int y, int N) {
        if (N == 1) {
            arr[x][y] = "*";
            return; 
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    recur(arr, x + i * (N / 3), y + j * (N / 3), N / 3);
                }
            }
        }
    }
}
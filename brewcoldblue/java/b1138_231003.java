import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tallerToLeft = new int[N];
        int[] result = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tallerToLeft[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            int space = 0;
            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {
                    if (space == tallerToLeft[i - 1]) {
                        result[j] = i;
                        break;
                    }
                    space++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

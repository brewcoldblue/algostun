import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(ms(N, A, B));
    }

    public static int ms(int N, int[] A, Integer[] B) {
        Arrays.sort(A);
        Integer[] Bi = new Integer[N];
        for (int i = 0; i < N; i++) {
            Bi[i] = i;
        }
        Arrays.sort(Bi, (i, j) -> B[j].compareTo(B[i]));

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[Bi[i]];
        }
        return S;
    }
}

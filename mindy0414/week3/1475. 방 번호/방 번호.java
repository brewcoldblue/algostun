import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] ar = new int[10];
        for (int i = 0; i < str.length(); i++)
            ar[Integer.parseInt(str.substring(i, i+1))]++;

        int tmp = (ar[6] + ar[9] + 1) / 2;
        ar[6] = tmp;
        ar[9] = tmp;

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if (ans < ar[i]) ans = ar[i];
        }
        System.out.println(ans);
    }
}
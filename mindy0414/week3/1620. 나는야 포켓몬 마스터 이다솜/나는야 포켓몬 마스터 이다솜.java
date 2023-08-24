import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            hm1.put(Integer.toString(i), tmp);
            hm2.put(tmp, Integer.toString(i));
        }

        while(M-->0) {
            String tmp = br.readLine();
            if(hm1.containsKey(tmp))
                System.out.println(hm1.get(tmp));
            else System.out.println(hm2.get(tmp));
        }

    }
}
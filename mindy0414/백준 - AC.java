import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        out:
        for (int t = 0; t < T; t++) {
            String rd = br.readLine();
            int l = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            tmp = tmp.replace("[", "");
            tmp = tmp.replace("]", "");

            ArrayDeque<String> ad;
            if(tmp.equals("")) ad = new ArrayDeque<>();
            else ad = new ArrayDeque<>(Arrays.asList(tmp.split(",")));

            int now = 0; // 0: front, 1: back
            for (int i = 0; i < rd.length(); i++) {
                if (rd.substring(i, i + 1).equals("R"))
                    now = (now == 0) ? 1 : 0;
                else {
                    if(ad.isEmpty()) {
                        System.out.println("error");
                        continue out;
                    }
                    if (now == 0) ad.pollFirst();
                    else ad.pollLast();
                }
            }
            if(now == 0) System.out.println(Arrays.toString(ad.toArray()).replaceAll(" ", ""));
            else {
                System.out.print("[");
                if(!ad.isEmpty()) System.out.print(ad.pollLast());
                while(!ad.isEmpty()) System.out.print(","+ad.pollLast());
                System.out.println("]");
            }
        }
    }
}
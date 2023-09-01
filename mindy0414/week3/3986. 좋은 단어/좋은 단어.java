import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while(N-->0) {
            String str = br.readLine();
            Stack<String> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                String tmp = str.substring(i, i+1);
                if(s.isEmpty() || !s.peek().equals(tmp)) s.push(tmp);
                else if(s.peek().equals(tmp)) s.pop();
            }
            if(s.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}
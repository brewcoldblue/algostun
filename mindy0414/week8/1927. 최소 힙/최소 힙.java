import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N-->0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else pq.add(x);
        }
    }
}
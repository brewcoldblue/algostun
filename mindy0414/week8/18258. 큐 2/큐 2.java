import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] l;
    static int[] dp;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        while(N-->0) {
            StringTokenizer command = new StringTokenizer(br.readLine(), " ");

            switch(command.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(command.nextToken()));
                    break;

                case "pop" :
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.poll()).append('\n');
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if(q.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;

                case "front":
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.peek()).append('\n');
                    break;

                case "back":
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
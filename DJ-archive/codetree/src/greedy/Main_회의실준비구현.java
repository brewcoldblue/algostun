package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// dp로도 풀 수 있는데 그리디로 복습
public class Main_회의실준비구현 {
    static class Meeting implements Comparable<Meeting>{
        int s,e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        // 끝나는 시간 기준 오름차순
        @Override
        public int compareTo(Meeting m) {
            if (this.e == m.e) {
                return this.s - m.s;
            }
            return this.e - m.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetings);

        int cnt = 1;
        int prev = meetings.get(0).e;
        for (int i = 1; i < meetings.size(); i++) {
            if (prev <= meetings.get(i).s) {
                cnt++;
                prev = meetings.get(i).e;
            }
        }
        System.out.println(cnt);

    }

}

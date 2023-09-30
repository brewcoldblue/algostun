package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_쪼개어배낭채우기 {

    static class Jewel implements Comparable <Jewel>{
        int w,v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel j) {
            double x = (double) j.v / j.w - (double) this.v/this.w;
            if (x > 0) {
                return 1;
            } else if (x == 0) {
                return 0;
            } else return -1;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 수
        int M = Integer.parseInt(st.nextToken()); // 도둑 가방 크기
        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(w,v));
        }

        // 가치 / 무게 기준 내림차순으로 정렬
        Collections.sort(jewels);

        double ans = 0;
        for (int i = 0; i < N; i++) {
            int w = jewels.get(i).w;
            int v = jewels.get(i).v;
            if (M >= w) { // 현재 보석을 온전히 다 담을 수 있다면 그대로 담기
                M -= w;
                ans += v;
            } else { // 만약 부분만 담을 수 있다면 비율에 맞춰 담아준 뒤 종료
                ans += (double) M/w * v;
                break;
            }

        }
        System.out.printf("%.3f", ans);



    }

}

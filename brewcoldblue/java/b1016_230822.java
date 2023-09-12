import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] notsq = new boolean[(int)(max - min + 1)];
        Arrays.fill(notsq, true); //모든 수를 제곱ㄴㄴ수로 가정함

        for (long i = 2; i * i <= max; i++) { //2의 제곱부터 나눠봄
            long start = i * i - (min % (i * i)); //min을 제곱으로 나눈 나머지가 0이면
            if (start == i * i) start = 0; //제곱 ㄴㄴ수 아님

						//start부터 max까지 i*i 간격으로 검사하는데, 어떤 수가 제곱ㄴㄴ수가 아니면
						//어떤 수 + i*i 도 나누어 떨어지니까 전부다 체크해줌
            for (long j = start; j <= max - min; j = j + i * i)  notsq[(int)j] = false;
        }
        

        int count = 0;
        for (boolean b : notsq) if (b) count++;

        System.out.println(count);
    }
}

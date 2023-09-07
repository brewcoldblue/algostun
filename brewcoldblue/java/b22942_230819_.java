// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.util.StringTokenizer;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         int[][] data = new int[N][2];

//         for (int i = 0; i < N; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             data[i][0] = Integer.parseInt(st.nextToken());  // 중심이 되는 x좌표
//             data[i][1] = Integer.parseInt(st.nextToken());  // 반지름
//         }

//         System.out.println(checkCircles(N, data));
//     }

//     public static String checkCircles(int N, int[][] data) {
//         for (int i = 0; i < N; i++) {
//             for (int j = i + 1; j < N; j++) { 
//                 int x1 = data[i][0];
//                 int r1 = data[i][1];
//                 int x2 = data[j][0];
//                 int r2 = data[j][1];

//                 int dist = Math.abs(x2 - x1);  // 중점의 차
//                 int sum = r1 + r2;  // 반지름 합
//                 int diff = Math.abs(r1 - r2);  // 반지름 차
                
//                 // 중점의 차가 반지름의 합보다 작고(겹침), 반지름의 차보다는 커야 합니다(동심원같은 것 걸러야 됨)
//                 if (diff < dist && dist < sum) {
//                     return "NO";
//                 }
//             }
//         }
//         return "YES";
//     }
// }

//위 풀이는 초과가 나서 (N^2) 여서, NlogN 정도로 줄일수있는지..


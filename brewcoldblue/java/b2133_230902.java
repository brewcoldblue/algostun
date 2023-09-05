// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Scanner;
// import java.util.Set;

// class Case {
// 	int twos;
// 	int fours;

// 	public Case(int twos, int fours) {
// 		//N을 2와 4로 분할하고
// 		//각각의 경우의 수에 대해 (2의 개수 * 3 + 4의 개수 * 2)를 구해
// 		//합을 출력하면 될듯
// 		this.twos = twos;
// 		this.fours = fours;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Case [twos=" + twos + ", fours=" + fours + "]";
// 	}

	
// }

// public class b2133_230902 {

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int N = sc.nextInt();

// 		List<Case>[][] dp = new ArrayList[N+1][N+1];


// 		if(N%2 == 1) { //홀수면 아예 만들수가 없어용
// 			System.out.println(0);
// 			return;
// 		}
// 		if(N == 2) { //2면 그냥 하나밖에 안댐
// 			System.out.println(3);
// 			return;
// 		}

// 		for(int i=0; i<=N; i++) {
// 			for(int j=0; j<=N; j++) {
// 				dp[i][j] = new ArrayList<>();
// 				//초기화...
// 			}
// 		}

// 		dp[0][0].add(new Case(0,0));
// 		if(N>=2) dp[2][1].add(new Case(1,0)); // 2를 만드는 방법
//     if(N>=4) dp[4][1].add(new Case(0,1)); // 4를 만드는 방법
// 		//초기화

// 		for(int i=1; i<=N; i++) { //1부터 N까지 순회함
// 			for(int j=1; j<=i/2; j++) {
// 				//절반까지만 순회해야함. 왜냐면 j*2 = i이기 때문에
// 				//2가 j개를 초과할수는 업슴
// 				if((N-2*j)%4 != 0) continue; //2를 구성완료했는데 4로 나눈 나머지가 있으면 그 쌍은 안됨
// 				if(i-2 >= 0) for(Case c: dp[i-2][j-1]) dp[i][j].add(new Case(c.twos+1, c.fours));
// 				if(i-4 >= 0) for(Case c: dp[i-4][j]) dp[i][j].add(new Case(c.twos,c.fours+1));
// 				//2나 4를 사용해 i를 만드는 방법
// 				// = i-2를 j-1개의 2로 만드는 방법 (2를 하나 추가할 때, 2는 j-1개여야 함)
// 				// + i-4를 j개의 2로 만드는 방법 (4를 하나 추가할 때, 2는 그대로 있음)
// 			}
// 		}

// 		int answer = 0;
//     for (int j=0; j<=N/2; j++) {

// 				System.out.println(dp[N][j].toString());
// 				//이거 찍었을때 중복이 발생하는것 같음.
// 				// 예를들어 N=12일때 2,2인 Case가 6개 나와야하는데,
// 				// 2244, 2424, 2442, 4242, 4224, 4422
// 				// Case(3, X)는 존재할수 없으므로 걍 넘어가야하는데,
// 				// dp[N][3]에 Case(2, 2)가 3개 찍힘..
// 				// 마찬가지로 dp[N][5]에도..
// 				// answer = answer + (j*3 + ((N - 2*j) / 4) * 2);
// 				// System.out.println(answer);
// 			}
// 		System.out.println(answer);
// 	}
// }

import java.util.Scanner;

public class b2133_230902 {
    
    // idx일 때 가능한 타일링 방법의 수
    static int[] dp = new int[31];

    public static int sol(int n) {
        // 기본값 설정
        dp[0] = 1;  // 0일 때는 1가지 (아무것도 안하는것도 1가지임; 삽질너무많이함)
        dp[1] = 3;  // 2일 때는 3가지
        
        // 홀수면 아예 안되고
        if (n % 2 != 0) return 0;
				// 2면 그냥 3가지
        if (n == 2) return 3;

        // dp 배열 채우기
        for (int i = 2; i <= n / 2; ++i) {
            // 3x2 타일을 추가하는 경우
            dp[i] += dp[i-1] * 3;

            // 3x4, 3x6, ... 타일을 추가하는 경우
            // 각각의 경우마다 2가지 방법이 존재
            for (int j = i - 2; j >= 0; --j) {
                dp[i] += 2 * dp[j];
            }
        }
        
        return dp[n / 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sol(n));  // 결과 출력
    }
}

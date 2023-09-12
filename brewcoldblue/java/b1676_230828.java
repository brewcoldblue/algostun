import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        
        //그 안에 2x5가 몇개 있는지 세면됨
        //근데 2는 5보다 무조건 많기떄문에
        //5만 세면됨
        while (N > 0) {
            N /= 5;
            count += N;
        }
        
        System.out.println(count);
    }
}

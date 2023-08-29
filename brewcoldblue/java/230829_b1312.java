import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            A = (A % B) * 10;
        }
        
        System.out.println(A / B);
    }
}

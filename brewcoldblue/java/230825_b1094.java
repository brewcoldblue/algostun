import java.util.PriorityQueue;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        PriorityQueue<Integer> sticks = new PriorityQueue<>();
        sticks.add(64);
        
        while (true) {
            int sum = 0;
            for (int stick : sticks) {
                sum += stick;
            }

            if (sum == X) {
                break;
            }

            int smallestStick = sticks.poll();
            int halfStick = smallestStick / 2;

            if (sum - halfStick >= X) {
                sticks.add(halfStick);
            } else {
                sticks.add(halfStick);
                sticks.add(halfStick);
            }
        }

        System.out.println(sticks.size());
    }
}

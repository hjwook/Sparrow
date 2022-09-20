package p11047;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
     * 10 4790
     * 1
     * 5
     * 10
     * 50
     * 100
     * 500
     * 1000
     * 5000
     * 10000
     * 50000
     * 
     */
    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(System.in);

            int N = input.nextInt();
            int K = input.nextInt();

            int[] nums = new int[N];

            int result = 0;
            for (int i = 0; i < N; i++) {
                nums[i] = input.nextInt();
            }

            for (int i = N - 1; i >= 0; i--) {
                if (K >= nums[i]) {
                    result += K / nums[i];
                    K = K % nums[i];
                }

            }
            System.out.println(result);

            // rd.close();
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

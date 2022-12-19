package p2981;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int gcd(int a, int b) {
        int c;
        while (b > 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        // nums[i]-nums[i-1] 들의 공약수가 나머지가 모두 같게 되는 M
        int gcdNum = nums[1] - nums[0];

        for (int i = 2; i < N; i++) {
            gcdNum = gcd(gcdNum, nums[i] - nums[i - 1]);
        }
        for (int i = 2; i <= gcdNum; i++) {
            if (gcdNum % i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}

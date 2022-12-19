package p3036;

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

        int fRing = sc.nextInt();

        for (int i = 1; i < N; i++) {
            int ring = sc.nextInt();
            int gcdVal = gcd(fRing, ring);
            sb.append(fRing / gcdVal).append("/").append(ring / gcdVal).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}

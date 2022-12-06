package p2609;

import java.util.Scanner;

public class Main {
    // 소수를 판별하는 함수
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int min = Math.min(n1, n2);
        int gcd = 1;

        for (int i = 2; i <= min; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
        System.out.println(n1 * n2 / gcd);
        // int tmp1 = n1;
        // int tmp2 = n2;
        // boolean isFind = false;

        // do {
        // isFind = false;
        // min = Math.min(tmp1, tmp2);
        // for (int i = 2; i <= min; i++) {
        // // i가 소수가 아니라면 skip24 18
        // if (!isPrime(i)) {
        // continue;
        // }
        // // 둘다 나누어 떨어지는 소수를 곱해서 모으면 최대공약수
        // if (tmp1 % i == 0 && tmp2 % i == 0) {
        // comFac *= i;
        // tmp1 /= i;
        // tmp2 /= i;
        // isFind = true;
        // break;
        // }
        // }

        // } while (isFind);

        // System.out.println(comFac);
        // System.out.println(comFac * (n1 / comFac) * (n2 / comFac));
        sc.close();
    }
}
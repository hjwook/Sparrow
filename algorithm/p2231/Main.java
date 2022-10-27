package p2231;

import java.util.Scanner;

public class Main {
    // 각 자릿수 합 리턴 함수
    public static int digitSum(int N) {
        if (N < 10) {
            return N;
        }
        return N % 10 + digitSum(N / 10);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean isFind = false;
        // 생성자 찾기
        for (int i = 1; i < N; i++) {
            if (i + digitSum(i) == N) {
                System.out.println(i);
                isFind = true;
                break;
            }
        }
        // 생성자 없는경우 0 출력
        if (!isFind) {
            System.out.println("0");
        }

        sc.close();
    }
}

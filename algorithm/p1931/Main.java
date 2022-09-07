package p1931;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */
public class Main {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int[][] inputs = new int[N][2];
            for (int i = 0; i < N; i++) {
                inputs[i][0] = sc.nextInt();
                inputs[i][1] = sc.nextInt();
            }

            Arrays.sort(inputs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                }
            });

            int beforeEnd = inputs[0][1];
            int result = 1;
            for (int i = 1; i < N; i++) {
                if (inputs[i][0] >= beforeEnd) {
                    beforeEnd = inputs[i][1];
                    result++;
                }
            }

            /*
             * for(int i=0; i<N; i++){
             * System.out.println(inputs[i][0] + "||"+inputs[i][1]);
             * }
             */
            System.out.println(result);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package p1182;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    static int combination2(int[] arr, boolean[] visited, int n, int r, int S) {

        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i])
                    sum += arr[i];// System.out.print(arr[i]+" ");
            }
            if (sum == S)
                return 1;
            else
                return 0;
        }
        if (n == arr.length)
            return 0;

        int partSum = 0;
        // n을 고른경우
        visited[n] = true;
        partSum += combination2(arr, visited, n + 1, r - 1, S);
        // n을 고르지 않은 경우
        visited[n] = false;
        partSum += combination2(arr, visited, n + 1, r, S);

        return partSum;
    }

    public static void main(String args[]) {
        try {
            // BufferedReader rd = new BufferedReader(new FileReader("p1182.txt"));
            Scanner input = new Scanner(System.in);

            String inputString;// take input String

            String[] inputs;

            // inputString=rd.readLine();
            // inputs = inputString.split(" ");

            // int N = Integer.parseInt(inputs[0]);
            // int S = Integer.parseInt(inputs[1]);

            int N = input.nextInt();
            int S = input.nextInt();

            int[] nums = new int[N];
            boolean[] visited = new boolean[N];

            // inputString=rd.readLine();
            // inputs = inputString.split(" ");

            for (int i = 0; i < N; i++) {
                nums[i] = input.nextInt();// Integer.parseInt(inputs[i]);
                visited[i] = false;
            }

            // System.out.println(combi(3,2));
            int result = 0;
            for (int i = 1; i <= N; i++) {
                result += combination2(nums, visited, 0, i, S);
            }
            System.out.println(result);

            // rd.close();
            // input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package p1182;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    static int combi(int n, int r) {
        if (n == r || r == 0)
            return 1;

        else
            return combi(n - 1, r - 1) + combi(n - 1, r);
    }

    static void combination(int[] arr, boolean[] visited, int n, int r) {

        if (r == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i])
                    System.out.print(arr[i] + " ");
            }
            System.out.println(" ");
            return;
        }
        if (n == arr.length)
            return;
        visited[n] = true;
        combination(arr, visited, n + 1, r - 1);

        visited[n] = false;
        combination(arr, visited, n + 1, r);
    }

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

        visited[n] = true;
        partSum += combination2(arr, visited, n + 1, r - 1, S);

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

            /*
             * int N = input.nextInt();
             * int S = input.nextInt();
             * 
             * int [] nums = new int[N];
             * boolean[] visited = new boolean[N];
             * 
             * 
             * //inputString=rd.readLine();
             * //inputs = inputString.split(" ");
             * 
             * for(int i=0; i<N ; i++){
             * nums[i] = input.nextInt();//Integer.parseInt(inputs[i]);
             * visited[i] = false;
             * }
             * 
             * //System.out.println(combi(3,2));
             * int result = 0;
             * for(int i=1; i<=N; i++){
             * result += combination2(nums,visited,0,i,S);
             * }
             * System.out.println(result);
             */

            int arr1[][] = { { 1, 2 }, { 4, 5 }, { 5, 6 } };

            System.out.println(arr1[0][1]);

            // rd.close();
            // input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

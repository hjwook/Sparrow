package p13460;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String args[]) {
        try {
            BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            // Scanner input = new Scanner(System.in);

            String inputString;// take input String
            inputString = rd.readLine();

            // int N = Integer.parseInt(inputString);
            // int M =input.nextInt();

            String[] inputSplit = inputString.split(" ");

            int N = Integer.parseInt(inputSplit[0]);
            int M = Integer.parseInt(inputSplit[1]);

            char[][] board = new char[N][M];

            for (int i = 0; i < N; i++) {
                inputString = rd.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = inputString.charAt(j);
                }
            }

            /*
             * for(int i=0; i<N; i++){
             * for(int j=0; j<M; j++){
             * System.out.print(board[i][j]);
             * }
             * System.out.println("");
             * }
             */

            System.out.println(N + M);
            // sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

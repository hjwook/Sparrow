package p3078;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static long cal(int num) {
        long result = 0;
        if (num <= 1)
            return 0;
        for (int i = 1; i < num; i++) {
            result += i;
        }
        return result;
    }

    public static void main(String args[]) {
        try {
            // BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
            Scanner input = new Scanner(System.in);

            String inputString;// take input String
            // inputString=rd.readLine();

            // int num = Integer.parseInt(inputString);
            // int num =input.nextInt();

            // String [] inputSplit = inputString.split(" ");

            // int N = Integer.parseInt(inputSplit[0]);
            // int K = Integer.parseInt(inputSplit[1]);
            int N = input.nextInt();
            int K = input.nextInt();
            // Stack<POS> lstack = new Stack<>();

            // Queue<String> [] q = new Queue[20];
            // Queue<String> q = new LinkedList();
            int sizeOfQ = 22;
            Queue<Integer>[] q = new LinkedList[sizeOfQ];
            for (int i = 0; i < sizeOfQ; i++) {
                q[i] = new LinkedList();
            }
            // System.out.println(q[0].isEmpty());
            long result = 0;
            input.nextLine();
            for (int i = 0; i < N; i++) {
                // inputString = rd.readLine();
                inputString = input.nextLine();

                int index = inputString.length();

                if (!q[index].isEmpty()) {
                    if ((i - q[index].peek()) <= K)
                        q[index].offer(i);
                    else {
                        q[index].poll();
                        result += q[index].size();
                    }

                } else
                    q[index].offer(i);

            }
            for (int i = 0; i < sizeOfQ; i++) {
                result += cal(q[i].size());
            }
            System.out.println(result);
            input.close();
            // rd.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

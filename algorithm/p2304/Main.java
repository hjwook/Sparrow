package p2304;

import java.util.Scanner;

import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;

class POS {
    public int L;
    public int H;

    public POS() {
        L = 0;
        H = 0;
    }

    public POS(int L, int H) {
        this.L = L;
        this.H = H;
    }

}

public class Main {
    public static void main(String args[]) {
        // try {
        // BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        int[] posAry = new int[num];
        HashMap<Integer, Integer> LMap = new HashMap<Integer, Integer>();

        int sum = 0;

        POS[] inputAry = new POS[num];
        Stack<POS> lstack = new Stack<>();
        Stack<POS> rstack = new Stack<>();

        for (int i = 0; i < num; i++) {
            int L = input.nextInt();
            int H = input.nextInt();
            LMap.put(L, H);
            posAry[i] = L;

        }
        Arrays.sort(posAry);

        for (int i = 0; i < num; i++) {
            inputAry[i] = new POS(posAry[i], LMap.get(posAry[i]));

        }

        for (int i = 0; i < num; i++) {
            int L = inputAry[i].L;
            int H = inputAry[i].H;

            if (lstack.empty())
                lstack.push(new POS(L, H));
            else {
                if (lstack.peek().H < H) {
                    sum += (L - lstack.peek().L) * lstack.peek().H;
                    lstack.push(new POS(L, H));
                }
            }

        }
        for (int i = num - 1; i >= 0; i--) {
            int L = inputAry[i].L;
            int H = inputAry[i].H;

            if (rstack.empty())
                rstack.push(new POS(L, H));
            else {
                if (rstack.peek().H < H) {
                    sum += (rstack.peek().L - L) * rstack.peek().H;
                    rstack.push(new POS(L, H));
                }
            }

        }
        if (rstack.peek().L == lstack.peek().L)
            sum += lstack.peek().H;
        else
            sum += (rstack.peek().L + 1 - lstack.peek().L) * lstack.peek().H;

        System.out.println(sum);

        input.close();
        // rd.close();
        // }
        // catch (Exception e){
        // System.out.println(e);
        // }
    }
}
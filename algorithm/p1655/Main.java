package p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

        }
        br.close();
    }
}

// 중간값 가운데..
// 왼쪽은 최대힙 오른쪽은 최소...?

// -99
// 1 2
// 10 5 7 5
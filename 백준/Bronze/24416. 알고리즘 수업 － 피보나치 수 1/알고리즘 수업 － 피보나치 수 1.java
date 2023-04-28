import java.util.Scanner;

public class Main {

  public static int[] memo = new int[41];
  public static int cnt1 = 0;
  public static int cnt2 = 0;

  public static int fib(int n) {
    if (n == 1 || n == 2) {
      cnt1++;
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  public static int fibonacci(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    if (memo[n] == 0) {
      cnt2++;
      memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
    return memo[n];
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    fib(n);
    fibonacci(n);

    System.out.println(Integer.toString(cnt1) + " " + Integer.toString(cnt2));
    sc.close();
  }
}
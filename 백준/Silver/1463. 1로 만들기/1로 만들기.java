import java.util.Scanner;

public class Main {
	
	public static int [] memo = new int [1000001];
	public static int makeOne ( int n){
		if(n == 1) return 0;
		if(n == 2) return 1;
		if(n == 3) return 1;
		
		boolean isMul3 = false;
		boolean isMul2 = false;
		
		if(n%3 ==0) isMul3 = true;
		if(n%2 ==0) isMul2 = true;
		
		if(memo[n] == 0) {
			if(isMul3 && isMul2) memo[n] = Math.min(Math.min(makeOne(n/3), makeOne(n/2)),makeOne(n-1))+1;
			else if (isMul2 && !isMul3) memo[n] = Math.min(makeOne(n/2), makeOne(n-1)) +1;
			else if (isMul3 && !isMul2) memo[n] = Math.min(makeOne(n/3), makeOne(n-1)) +1;
			else memo[n] = makeOne(n-1) +1;
		}
		
		return memo[n];
	}
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(makeOne(N));
		
		sc.close();
	}
}
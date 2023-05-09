import java.util.Scanner;

public class Main {
	
	public static int [] memo = new int[1000001];
	public static int cntTile(int N){
		if(N <=0) return 0;
		else if (N ==1 ) return 1;
		else if (N==2) return 2;
		
		if(memo[N-1] == 0 ) memo[N-1] = cntTile(N-1);
		if(memo[N-2] == 0 ) memo[N-2] = cntTile(N-2);
		
		return (memo[N-1] + memo[N-2])%15746;
	}
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(cntTile(N));
		
		
		sc.close();
		
	}
}

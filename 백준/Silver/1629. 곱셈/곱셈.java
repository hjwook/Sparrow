
import java.util.Scanner;

public class Main {
	
	static long remainder(int A, int B, int C){
		if(B == 0) return 1;
		else if(B==1) return A%C;
		else if (B % 2 ==0) {
			long temp = remainder(A,B/2,C)%C;
			return (temp*temp)%C;
		}
		else {
			long temp = remainder(A,B/2,C)%C;
			return (((temp*temp)%C)*A)%C;
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println(remainder(A,B,C));

		
		sc.close();
	}
}

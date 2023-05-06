import java.util.Scanner;
/*
55-50+40
 */
public class Main {
	public static void main(String args[]){
		try {	
			Scanner sc= new Scanner(System.in);
			
			
			long result = 0;
			
			int N = sc.nextInt();
			
			//int minCost = 1000000000;
			int [] dist = new int[N-1];
			
			for(int i=0; i<N-1; i++){
				dist[i] = sc.nextInt();
			}
			
			int minCost = sc.nextInt();
			for(int i=1; i<N; i++){
				int cost = sc.nextInt();
				
				if(cost<minCost) {
					result += minCost*dist[i-1];
					minCost = cost;
				}
				else{
					result += minCost*dist[i-1];
				}
				
			}
			
	
			
			System.out.println(result);
			sc.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
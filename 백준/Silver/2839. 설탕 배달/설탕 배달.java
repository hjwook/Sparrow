import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int div5 = N/5;//5로 나눈 몫
		int result = -1;
		for(int i=div5; i>=0 ; i--){
			if((N-(i*5))%3 ==0){
				result = i + (N-(i*5))/3;
				break;
			}
		}
		System.out.println(result);
		
		
	
	}
}
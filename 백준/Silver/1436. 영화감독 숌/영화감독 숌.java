import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int i =666;
		int count =0;
		while(true){
			if(Integer.toString(i).contains("666")){
				count++;
			}
			if(count ==N) break;
			i++;
		}
		
		System.out.println(i);
	}
}
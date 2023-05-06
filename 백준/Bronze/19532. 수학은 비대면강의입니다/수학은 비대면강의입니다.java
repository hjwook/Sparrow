import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int x = -1000;
		int y = -1000;
		boolean isFind = false;
		for(int i=-999; i<=999; i++){
			if(isFind) break;
			for(int j=-999; j<=999; j++){
				if(isFind) break;
				if(a*i + b*j ==c && d*i+e*j ==f){
					x = i;
					y = j;
					isFind = true;
				}
			}
		}
		System.out.println(x+" "+y);
	}
}
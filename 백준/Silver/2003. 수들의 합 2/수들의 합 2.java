import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int [] input = new int[N];
	    for(int i=0; i<N; i++){
	    	input[i] = Integer.parseInt(st.nextToken());
	    }
	    int result = 0;
	    for(int i=0; i<N;i++){
	    	int sum =0;
	    	for(int j=i; j<N;j++){
	    		sum +=input[j];
	    		if(sum == M) {
	    			result++;
	    			break;
	    		}else if(sum >M){
	    			break;
	    		}
	    	}
	    }
	    
	    System.out.println(result);
	    
	    
	}
}
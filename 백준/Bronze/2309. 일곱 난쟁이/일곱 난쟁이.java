
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String args[]){
		try {	
			//BufferedReader rd = new BufferedReader(new FileReader("p2309.txt"));
			Scanner input = new Scanner(System.in);
			
			String inputString;//take input String	
			
			int [] inputs = new int [9];
			boolean [] excepFlag = new boolean[9];
			
		
			for(int i=0; i <9; i++){
				inputs[i] = 0;
				excepFlag[i] = false;
				
				//inputString=rd.readLine();
				//inputs[i] = Integer.parseInt(inputString);
				inputs[i] = input.nextInt();
			}
			Arrays.sort(inputs);
			
			int sum = 0;
			
			Loop1 :
			for(int i=0; i <9; i++){
				for(int j=i+1; j<9; j++){
					excepFlag[i] = true;
					excepFlag[j] = true;
				
				
					for(int k=0; k<9; k++){
						if(!excepFlag[k]) sum += inputs[k];
					}
					//System.out.println(i+"||"+j+"||"+sum);
					if(sum == 100) break Loop1;
					
					sum = 0;
					
					for(int k=0; k<9; k++){
						excepFlag[k] = false;
					}
				}
				
			}
			
			for(int j=0; j<9; j++){
				if(!excepFlag[j]) System.out.println(inputs[j]);
			}
			
			
			//rd.close();
			input.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}

import java.util.Scanner;
/*
55-50+40
 */
public class Main {
	public static void main(String args[]){
		try {	
			Scanner sc= new Scanner(System.in);
			String input = sc.nextLine();//sc.next("[0-9]+");
			int result = 0;
			boolean isMinus = false;

			String temp ="";

			for(int i=0; i<input.length(); i++){
				char a = input.charAt(i);
				
				if('-' == a){
					if(!isMinus) result += Integer.parseInt(temp);
					else result -= Integer.parseInt(temp);
					isMinus = true;
					temp = "";
				}
				else if ('+' == a){
					if(!isMinus) result += Integer.parseInt(temp);
					else result -= Integer.parseInt(temp);
					temp = "";
				}
				else temp += Character.toString(a);
			}
			if(!isMinus) result += Integer.parseInt(temp);
			else result -= Integer.parseInt(temp);
	
			
			System.out.println(result);
			sc.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
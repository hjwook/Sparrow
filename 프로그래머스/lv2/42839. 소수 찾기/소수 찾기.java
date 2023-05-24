import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<Integer>();
    
    public boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2; i <num; i++ ){
            if(num%i ==0) return false;
        }
        return true;
    }

    public void combi(String cur, String remain){
        if("".equals(remain)) return;
        for(int i=0; i<remain.length(); i++){
            set.add(Integer.parseInt(cur+remain.charAt(i)));
            combi(cur+remain.charAt(i), remain.substring(0,i) +remain.substring(i+1,remain.length()) );
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        combi("",numbers);

        //Object
		Iterator iter = set.iterator();//반복자
		while(iter.hasNext()) {
            if(isPrime(Integer.parseInt(iter.next().toString()))) answer++;
		}
        
        return answer;
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] cloth = new int [n+1];
        
        for(int i=0; i<=n; i++){
            cloth[i] =1;
        }
        for(int i=0; i<lost.length; i++){
            cloth[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++){
            cloth[reserve[i]]++;
        }
        
        for(int i=1; i<=n ; i++){
            if(cloth[i] == 0){
                if(cloth[i-1]>1){
                    cloth[i-1]--;
                    cloth[i]++;
                    continue;
                }
                else if(i<n && cloth[i+1]>1){
                    cloth[i+1]--;
                    cloth[i]++;
                    continue;
                }
            }
        }
        for(int i=1; i<=n ; i++){
            if(cloth[i]>=1) answer++;
        }
                
        return answer;
    }
}
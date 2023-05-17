class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=3; i<5000; i++){
            for(int j=i; j<5000; j++){
                if((i+j)*2-4 == brown && (i-2)*(j-2) ==yellow){
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}
//옐로우 가로 *2 + 옐로우 세로 *2 + 4
//(가로+세로)*2-4
//(가로-2) *(세로-2)
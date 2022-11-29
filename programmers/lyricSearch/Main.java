class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = {};
        answer = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int start = queries[i].indexOf("?");
            int end = queries[i].lastIndexOf("?");
            //System.out.println(start + "|"+ end);
            for(int j=0; j<words.length; j++){
                //질의의 길이와 단어의 길이가 다르면 매칭 x
                if(queries[i].length() !=words[j].length() ){
                    continue;
                }
                //?가 없는 질의는 그대로 비교
                if(start ==-1 && end == -1){
                    if(queries[i].equals(words[j])){
                        answer[i]++;
                    }
                }
                //end index 가 ? -> 접미사
                else if(end == queries[i].length()-1){
                    if(queries[i].substring(0,start).equals(words[j].substring(0,start))){
                        answer[i]++;
                    }
                }
                //start index 가 ? -> 접두사
                else if(start ==0){
                    if(queries[i].substring(end+1).equals(words[j].substring(end+1))){
                        answer[i]++;
                    }
                }
                
                
            }
        }
        
        return answer;
    }
}
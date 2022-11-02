package programmers.secretMap;

//class Solution {
class Main {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
        }
        for (int i = 0; i < n; i++) {
            String input1 = Integer.toBinaryString(arr1[i]);
            String input2 = Integer.toBinaryString(arr2[i]);

            for (int j = 0; input1.length() < n; j++) {
                input1 = "0" + input1;
            }
            for (int j = 0; input2.length() < n; j++) {
                input2 = "0" + input2;
            }
            for (int j = 0; j < n; j++) {
                if (input1.charAt(j) == '1' || input2.charAt(j) == '1') {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }
}
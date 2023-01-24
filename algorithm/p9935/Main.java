package p9935;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine();
    String bomb = sc.nextLine();
    StringBuilder sb = new StringBuilder();

    Stack<Character> stack = new Stack<>();
    Stack<Character> temp = new Stack<>();
    //입력을 한글자씩 stack에 넣으며, 폭발문자의 길이이상일때
    //뒤에서부터 매칭시켜서, 매치가 되면 폭발, 아니면 다시넣기.
    for (int i = 0; i < input.length(); i++) {
      char inputChar = input.charAt(i);
      stack.push(inputChar);

      if (stack.size() >= bomb.length()) {
        boolean isMatch = true;
        //폭발문자와 매칭 검사
        for (int j = bomb.length() - 1; j >= 0; j--) {
          //일치할때마다 임시 stack으로 옮김
          if (stack.peek() == bomb.charAt(j)) {
            temp.push(stack.pop());
          } else {
            isMatch = false;
            break;
          }
        }
        //매치가 안되면, 임시stack에 있던걸 다시 옮김
        if (!isMatch) {
          while (!temp.isEmpty()) {
            stack.push(temp.pop());
          }
        }
        //매치가 되면 임시stack clear
        else {
          temp.clear();
        }
      }
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    sb = sb.reverse();
    System.out.println(sb.length() > 0 ? sb : "FRULA");
    sc.close();
  }
}

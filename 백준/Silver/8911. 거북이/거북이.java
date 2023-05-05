import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static int[] dx = { 0, 1, 0, -1 };//북동남서
  public static int[] dy = { 1, 0, -1, 0 };//복뚱남서연

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(st.nextToken());

    for (int i = 0; i < T; i++) {
      String input = br.readLine();
      int curX = 0;
      int curY = 0;
      int curD = 0;
      int minX = 0;
      int minY = 0;
      int maxX = 0;
      int maxY = 0;
      for (int j = 0; j < input.length(); j++) {
    	if ('F' == input.charAt(j)) {
          curX += dx[curD];
          curY += dy[curD];
          if (curX > maxX) maxX = curX;
          if (curX < minX) minX = curX;
          if (curY > maxY) maxY = curY;
          if (curY < minY) minY = curY;
        } else if ('B' == input.charAt(j)) {
          curX += dx[curD]*-1;
          curY += dy[curD]*-1;
          if (curX > maxX) maxX = curX;
          if (curX < minX) minX = curX;
          if (curY > maxY) maxY = curY;
          if (curY < minY) minY = curY;
        } else if ('L' == input.charAt(j)){
        	curD = (curD ==0)? 3: --curD;
        } else if ('R' == input.charAt(j)){
        	curD = (curD ==3)? 0: ++curD;
        } 
      }
      sb.append((maxX-minX)*(maxY-minY)).append("\n");
    }
    System.out.println(sb);
  }
}
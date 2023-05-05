import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static int[] dx = { -1, 0, 1, 0 };
  public static int[] dy = { 0, 1, 0, -1 };
  public static boolean[][] visited;
  public static int[][] map;

  public static void doClean(int curX, int curY, int curD) {
    visited[curX][curY] = true;
    boolean isClosed = true;
    for (int i = 0; i < 4; i++) {
      if (
        !visited[curX + dx[i]][curY + dy[i]] &&
        map[curX + dx[i]][curY + dy[i]] == 0
      ) isClosed = false;
    }
    //후진
    if (isClosed) {
      int backX = curX + dx[curD] * -1;
      int backY = curY + dy[curD] * -1;
      if (map[backX][backY] == 1) return;
      doClean(backX, backY, curD);
    } else {
      int newD = curD;
      int newX;
      int newY;
      do {
        newD = (newD == 0) ? 3 : newD - 1;
        newX = curX + dx[newD];
        newY = curY + dy[newD];
        if (!visited[newX][newY] && map[newX][newY] == 0) break;
      } while (true);
      doClean(newX, newY, newD);
    }
  }

  public static void main(String args[]) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(in.readLine());
    int curX = Integer.parseInt(st.nextToken());
    int curY = Integer.parseInt(st.nextToken());
    int curD = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    doClean(curX, curY, curD);
    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        result += visited[i][j] ? 1 : 0;
      }
    }
    System.out.println(result);
  }
}
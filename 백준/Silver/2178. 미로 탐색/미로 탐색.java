import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int N;
    public static int M;
    public static int[][] map;
    public static boolean[][] visited;

    public static void doBFS(){
        Queue<int []> q = new LinkedList<int []>();
        visited[0][0] = true;
        int [] temp = {0,0};
        q.add(temp);
  
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                break;
            }
            if (cur[0] - 1 >= 0 && map[cur[0] - 1][cur[1]] == 1 && !visited[cur[0] - 1][cur[1]]) {
                int[] temp2 = new int[2];
                visited[cur[0]-1][cur[1]] = true;
                temp2[0] = cur[0]-1;
                temp2[1] = cur[1];
                q.add(temp2);
                map[cur[0] - 1][cur[1]] = map[cur[0]][cur[1]] + 1;
            }
            if (cur[0] + 1 < N && map[cur[0] + 1][cur[1]] == 1 && !visited[cur[0] + 1][cur[1]]) {
                int[] temp2 = new int[2];
                visited[cur[0]+1][cur[1]] = true;
                temp2[0] = cur[0]+1;
                temp2[1] = cur[1];
                q.add(temp2);
                map[cur[0] +1][cur[1]] = map[cur[0]][cur[1]] + 1;
            }
            if (cur[1] - 1 >= 0 && map[cur[0]][cur[1] - 1] == 1 && !visited[cur[0]][cur[1] - 1]) {
                int[] temp2 = new int[2];
                visited[cur[0]][cur[1]-1] = true;
                temp2[0] = cur[0];
                temp2[1] = cur[1]-1;
                q.add(temp2);
                map[cur[0]][cur[1]-1] = map[cur[0]][cur[1]] + 1;
            }
            if (cur[1] + 1 < M && map[cur[0]][cur[1] + 1] == 1 && !visited[cur[0]][cur[1] + 1]) {
                int[] temp2 = new int[2];
                visited[cur[0]][cur[1] + 1] = true;
                temp2[0] = cur[0];
                temp2[1] = cur[1] + 1;
                q.add(temp2);
                map[cur[0]][cur[1]+1] = map[cur[0]][cur[1]] + 1;
            }
        }
        
    }

    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            input = br.readLine();
            String[] inputs = input.split(" ");
            N = Integer.parseInt(inputs[0]);
            M = Integer.parseInt(inputs[1]);
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }      
            }
            visited = new boolean[N][M];
            doBFS();
            System.out.println(map[N-1][M-1]);
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
}
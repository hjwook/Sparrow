import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] graph;
    public static boolean[] visited;
    
    public static void doDFS(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[V][i] == 1 && !visited[i]) {
                doDFS(i);
            }
        }
    }

    public static void doBFS(int V) {
        visited[V] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        System.out.print(V + " ");
        q.add(V);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    q.add(i);
                }
            }
            
        }
        
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new int[N + 1][N + 1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        doDFS(V);
        System.out.println();
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        doBFS(V);

        
        sc.close();
    
    }
}
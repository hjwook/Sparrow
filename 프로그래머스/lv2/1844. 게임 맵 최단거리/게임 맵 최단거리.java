import java.util.*;

class Solution {
    public boolean [][] visited;
    public int [][] cost;
    public int n;
    public int m; 
    public int INF = 999999999;
    public void doBFS(int[][] maps, int X, int Y){
        visited[X][Y] = true;
        Queue<int []> q = new LinkedList<int []>();
        int [] temp = {X,Y};
        q.add(temp);
        
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int curX = curr[0];
            int curY = curr[1];
            visited[curX][curY] = true;
            if(curX-1>=0 && maps[curX-1][curY] == 1){
                if(!visited[curX-1][curY]){
                    visited[curX-1][curY] = true;
                    int [] temp2 = {curX-1,curY};
                    q.add(temp2);
                    cost[curX-1][curY] = Math.min(cost[curX-1][curY],cost[curX][curY]+1);
                }
            }
            if(curX+1<n && maps[curX+1][curY] == 1){
                if(!visited[curX+1][curY]){
                    visited[curX+1][curY] = true;
                    int [] temp2 = {curX+1,curY};
                    q.add(temp2);
                    cost[curX+1][curY] = Math.min(cost[curX+1][curY],cost[curX][curY]+1);
                }
            }
            if(curY-1>=0&& maps[curX][curY-1] == 1){
                if(!visited[curX][curY-1]){
                    visited[curX][curY-1] = true;
                    int [] temp2 = {curX,curY-1};
                    q.add(temp2);
                    cost[curX][curY-1] = Math.min(cost[curX][curY-1],cost[curX][curY]+1);
                }
            }
             if(curY+1<m&& maps[curX][curY+1] == 1){
                if(!visited[curX][curY+1]){
                    visited[curX][curY+1] = true;
                    int [] temp2 = {curX,curY+1};
                    q.add(temp2);
                    cost[curX][curY+1] = Math.min(cost[curX][curY+1],cost[curX][curY]+1);
                    
                }
            }
            
        }
                
    }
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        cost = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cost[i][j] = INF;
            }
        }
        cost[0][0] = 1;
        visited = new boolean[n][m];
        
        doBFS(maps,0,0);
        
        if(cost[n-1][m-1] == INF) answer = -1;
        else answer = cost[n-1][m-1];
        
        return answer;
    }
}
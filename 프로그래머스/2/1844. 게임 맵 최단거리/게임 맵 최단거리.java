import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;
    static boolean[][] visit;
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        visit = new boolean[maps.length][maps[0].length];
        
        bfs(maps, 0, 0);
        
        if (answer == Integer.MAX_VALUE)
            answer = -1;
        
        return answer;
    }
    
    public static void bfs(int[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(x, y, 0));
        visit[x][y] = true;
        
        while (!q.isEmpty()) {
            
            Node tmp = q.poll();
            
            if (tmp.i == maps.length - 1 && tmp.j == maps[0].length -1) {
                answer = Math.min(answer, tmp.cnt + 1);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = tmp.i + dx[i];
                int ny = tmp.j + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if (maps[nx][ny] == 1 && visit[nx][ny] == false) {
                        q.add(new Node(nx, ny, tmp.cnt+1));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
    
    static class Node {
        int i, j, cnt;
        
        public Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}
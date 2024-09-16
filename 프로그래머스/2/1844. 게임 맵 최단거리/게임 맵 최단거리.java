import java.util.*;

class Solution {
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int Min = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        
        visit = new boolean[maps.length][maps[0].length];
        
        bfs(maps, 1);
        
        if (Min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return Min;
        }
    }
    
    void bfs(int[][] maps, int count) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0, count));
        visit[0][0] = true;
        
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            
            if (tmp.x == maps.length - 1 && tmp.y == maps[0].length - 1) {
                Min = Math.min(Min, tmp.cnt);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if (visit[nx][ny] == false && maps[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny, tmp.cnt+1));
                    }
                }
            }
        }
    }
    
    class Node {
        int x, y, cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
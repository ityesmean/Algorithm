import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	static int N, M, cnt = 0;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		bfs(1, 1);
		System.out.println(arr[N][M]);
	}

	static class Node {
		int i, j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(i, j));
		visit[i][j] = true;
		
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int x = tmp.i + dx[k];
				int y = tmp.j + dy[k];
				
				if (x >= 1 && x <= N && y >= 1 && y <= M && arr[x][y] != 0 &&!visit[x][y]) {
						
					q.offer(new Node(x, y));
					visit[x][y] = true;
					
					arr[x][y] = arr[tmp.i][tmp.j] + 1; 
				}
			}
		}
		
	}
	
	

}

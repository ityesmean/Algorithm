import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static boolean[][] visit;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		System.out.println(bfs(arr, 1, 1));
	}

	private static int bfs(int[][] arr, int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 1));
		visit[x][y] = true;
		
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			
			if (tmp.i == N && tmp.j == M) {
				return tmp.count;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp.i + dx[i];
				int ny = tmp.j + dy[i];
				
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
					if (visit[nx][ny] == false && arr[nx][ny] == 1) {
						visit[nx][ny] = true;
						q.add(new Node(nx, ny, tmp.count+1));
					}
				}
			}
			
		}
		return -1;
	}
	
	static class Node {
		int i, j, count;
		
		public Node(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
}

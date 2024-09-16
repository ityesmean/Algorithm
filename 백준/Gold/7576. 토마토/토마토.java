import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Node> q;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visit = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		q = new LinkedList<Node>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					q.add(new Node(i, j));
					visit[i][j] = 1;
				}
				
				else if (arr[i][j] == -1) {
					visit[i][j] = -1;
				}
			}
		}
		
		bfs(arr);
		
		int max = 0;
		boolean answer = true;
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[0].length; j++) {
				
				if (visit[i][j] == 0) {
					answer = false;
				}
				max = Math.max(visit[i][j], max);
			}
		}
		
		if (answer) {
			System.out.println(max-1);
		} else {
			System.out.println(-1);
		}
	}

	private static void bfs(int[][] arr) {
		
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			
			if (arr[tmp.x][tmp.y] == -1) {
				return;
			}
			
			/*for (int e = 0; e < M; e++) {
				for (int w = 0; w < N; w++) {
					System.out.print(visit[e][w] + " ");
				}
				System.out.println();
			}

			System.out.println();*/
			
			for (int a = 0; a < 4; a++) {
				int nx = dx[a] + tmp.x;
				int ny = dy[a] + tmp.y;
				
				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (visit[nx][ny] == 0) {
						visit[nx][ny] = visit[tmp.x][tmp.y] + 1;
						q.add(new Node(nx, ny));
					}
				}
			}
		}
		
	}
	
	static class Node {
		
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

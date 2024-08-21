
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] visit;
	static int answer = 0;
	static int max = 0;
	static Queue<Node> q;
	
	static class Node {
		int i, j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		int x = 0, y = 0;
		
		visit = new int[N][M];
		
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				if (arr[i][j] == 1) {
					q.add(new Node(i, j));
					visit[i][j] = 1;
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					answer = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(visit[i][j], max);
			}
		}
		if (answer != -1)
			System.out.println(max-1);
		else
			System.out.println(-1);
	}
	
	
	private static void bfs() {
		
		
		while (!q.isEmpty()) {
			
			Node tmp = q.poll();
			
			
			for (int k = 0; k < 4; k++) {
				int x = dx[k] + tmp.i;
				int y = dy[k] + tmp.j;
				
				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;
				
				if (visit[x][y] == 0 && arr[x][y] == 0) {
					arr[x][y] = 1;
					visit[x][y] = visit[tmp.i][tmp.j] + 1;
					q.add(new Node(x, y));
				}
				
			}
			
			
		}
	}

}

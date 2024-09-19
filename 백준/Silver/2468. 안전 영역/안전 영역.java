import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		int maxNum = 0;
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				maxNum = Math.max(maxNum, arr[i][j]);
			}
		}
		
		int answer = 0;
		int answer2 = 0;
		
		for (int h = 0; h <= maxNum; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == false && arr[i][j] > h) {
						bfs(i, j, h);
						if (cnt > 0) {
							answer++;
						}
					}
				}
			}
			answer2 = Math.max(answer, answer2);
			visit = new boolean[N][N];
			answer = 0;
		}
		
		System.out.println(answer2);
	}

	static void bfs(int i, int j, int h) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(i, j, 0));
		visit[i][j] = true;
		cnt = 1;
		
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			
			for (int x = 0; x < 4; x++) {
				int nx = dx[x] + tmp.x;
				int ny = dy[x] + tmp.y;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (visit[nx][ny] == false && arr[nx][ny] > h) {
						visit[nx][ny] = true;
						q.add(new Node(nx, ny, tmp.count+1));
					}
				}
			}
			
		}

	}
	
	static class Node {
		int x;
		int y;
		int count;
		
		public Node (int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}

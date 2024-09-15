import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(arr, V);
		System.out.println();
		for (int i = 0; i < visit.length; i++) {
			visit[i] = false;
		}
		bfs(arr, V);
		
	}

	public static void bfs(int[][] arr, int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		visit[V] = true;
		
		while (!q.isEmpty()) {
		
			int tmp = q.poll();
			
			System.out.print(tmp + " ");
			
			for (int i = 1; i <= N; i++) {
				
				if (arr[tmp][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.add(i);
				}
			}
		
		}
		
	}
	
	public static void dfs(int[][] arr, int V) {
		visit[V] = true;
		System.out.print(V + " ");
		
		for (int i = 1; i <= N; i++) {
			if (arr[V][i] == 1 && visit[i] == false) {
				dfs(arr, i);
			}
		}
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visit;
	static int count = 0;
	static int N;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		
		StringTokenizer st;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		bfs(arr, 1);
		System.out.println(count);
	}

	private static void bfs(int[][] arr, int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visit[a] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if (arr[tmp][i] == 1 && visit[i] == false) {
					q.add(i);
					visit[i] = true;
					count++;
				}
			}
		}
		
	}

}

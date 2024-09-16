import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int[][] arr;
	static int N;
	static boolean[][] visit;
	static int count = 1;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visit = new boolean[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (visit[i][j] == false && arr[i][j] == 1) {
					dfs(arr, i, j);
					list.add(count);
					count = 1;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void dfs(int[][] arr2, int x, int y) {
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
				if (visit[nx][ny] == false && arr[nx][ny] == 1) {
					visit[nx][ny] = true;
					count++;
					dfs(arr, nx, ny);
				}
			}
		}
	}

}

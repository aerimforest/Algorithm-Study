import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 84ms
// 메모리 : 11832KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		long[][] v = new long[N][N];
		v[0][0] = 1l;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				int nc = j + map[i][j];
				if(nc < N) {
					v[i][nc] += v[i][j];
				}
				int nr = i + map[i][j];
				if(nr < N) {
					v[nr][j] += v[i][j];
				}
			}
		}
		System.out.println(v[N-1][N-1]);
	
	}
}

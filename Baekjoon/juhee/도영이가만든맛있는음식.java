import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] food = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		
		min = 1000000001;
		dfs(0, new boolean[N], 0, 1, food);
		System.out.println(min);
	}
	static int min;
	private static void dfs(int cnt, boolean[] v, int bitter, int sour, int[][] food) {

		int N = food.length;
		if(cnt > 0) {
			min = Math.min(min, Math.abs(bitter - sour));
		}
		if(cnt == N) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(cnt+1, v, bitter + food[i][1], sour * food[i][0], food);
			v[i] = false;
		}
	}

}

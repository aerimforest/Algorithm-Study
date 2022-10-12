import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11984KB
public class Main {

	static int D;
	static int min;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] shortcut = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				shortcut[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = D;
		dfs(0, 0, shortcut);
		System.out.println(min);
	}
	private static void dfs(int load, int time, int[][] shortcut) {

		if(load > D) return;
		if(D - load + time < min) {
			min = D - load + time;
		}
		for (int[] is : shortcut) {
			int start = is[0];
			int end = is[1];
			int weight = is[2];
			if(start < load) continue;
			else if(start == load) dfs(end, time + weight, shortcut);
			else dfs(end, time + weight + start - load, shortcut);
		}
	}

}

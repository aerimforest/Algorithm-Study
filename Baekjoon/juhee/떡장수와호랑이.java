import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 124ms
// 메모리 : 14064KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer>[] days = new ArrayList[N];
		StringBuilder sb = new StringBuilder();
		int[] dont_give = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = new ArrayList<>();
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {				
				days[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		dduck(days, 0, 0, new int[N], new boolean[N][10]);
		System.out.println(-1);
	}

	private static void dduck(List<Integer>[] days, int cnt, int prev, int[] tiger, boolean[][] v) {

		int N = tiger.length;
		if(cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i : tiger) {
				sb.append(i).append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		boolean flag = false;
		for (int i : days[cnt]) {
			if(i == prev) continue;
			if(v[cnt][i]) continue;
			tiger[cnt] = i;
			flag = true;
			dduck(days, cnt + 1, i, tiger, v);
		}
		if(!flag) {
			v[cnt-1][prev] = true;
		}
	}

}

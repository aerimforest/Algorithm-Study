import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S;
	static int count;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
			dfs(0, false, 0, number);
		System.out.println(count);
	}

	private static void dfs(int total, boolean flag, int cnt, int[] number) {

		int N = number.length;
		if(cnt == N) {
			return;
		}
		if(total + number[cnt] == S) count++;
		dfs(total + number[cnt], true, cnt+1, number);
		dfs(total, flag, cnt + 1, number);
	}

}

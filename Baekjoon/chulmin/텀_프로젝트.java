
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9466 {
	
	static int N, count;
	static int[] want;
	static boolean[] visit, finish;
	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int ti=0; ti<T; ti++) {
			N = Integer.parseInt(br.readLine());
			
			want = new int[N+1];
			visit = new boolean[N+1];
			finish = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=N; i++) {
				want[i] = Integer.parseInt(st.nextToken());
			}

			count = 0;
			pro();
			System.out.println(N-count);
		}
		br.close();
	}

	private static void pro() {
		for(int i=1; i<=N; i++) {
			dfs(i);
		}
	}

	private static void dfs(int cur) {
		if(visit[cur])
			return;
		
		visit[cur] = true;
		int next = want[cur];

		if(!visit[next])
			dfs(next);
		if(visit[next] && !finish[next]) {
			count++;
			for(int i=next; i != cur; i = want[i])
				count++;
		}
		
		dfs(next);
		finish[cur] = true;
	}
}

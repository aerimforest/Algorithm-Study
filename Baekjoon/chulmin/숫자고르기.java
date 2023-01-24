import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 그래프가 순환을 이루고 있는지를 보면 된다.
	// 순환인 애들을 모두 더하면 된다.
	static int N, count;
	static int[] mat;
	static boolean[] visit;
	static boolean[] finish;
	static boolean[] isCycle;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		count = 0;
		visit = new boolean[N];
		finish = new boolean[N];
		isCycle = new boolean[N];
		for(int i=0; i<N; i++) {
			dfs(i);
		}
		System.out.println(count);
		for(int i=0; i<N; i++) {
			if(isCycle[i])
				System.out.println(i + 1);
		}
	}

	private static void dfs(int cur) {
		if(visit[cur])
			return;
		
		visit[cur] = true;
		int next = mat[cur];
		
		if(!visit[next])
			dfs(next);
		if(visit[next] && !finish[next]) {
			isCycle[cur] = true;
			count++;
			for(int i=next; i != cur; i = mat[i]) {
				isCycle[i] = true;
				count++;
			}
		}
		
		dfs(next);
		finish[cur] = true;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N];
		
		for(int i=0; i<N; i++) {
			int C = Integer.parseInt(br.readLine()) - 1;
			mat[i] = C;
		}
		
		br.close();
	}
}

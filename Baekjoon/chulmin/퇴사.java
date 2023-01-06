import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 퇴사 {
	static int N;
	static int[] dp;
	static ArrayList<int[]>[] list;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		
		for(int i=1; i<=N+1; i++) {
			dp[i] = dp[i-1];
			
			for(int[] j : list[i]) {
				int cur = dp[i - j[0]] + j[1];
				dp[i] = Math.max(cur, dp[i]);
			}
		}
//		for(int i: dp) {
//			System.out.print(i + " ");
//		}System.out.println();
		System.out.println(dp[N+1]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 6];
		dp = new int[N+2];
		
		for(int i=0; i<=N+5; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			list[i+t].add(new int[] {t, p});
		}
		
		br.close();
	}
}

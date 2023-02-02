import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// dp 문제
	
	static int[][] mat;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		mat = new int[M][N];
		dp = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			dp[i][0] = mat[i][0];
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<M; k++) {
					if(j==k) {
						dp[j][i] = Math.max(dp[j][i], dp[k][i-1] + mat[j][i]/2);
					}
					else 	
						dp[j][i] = Math.max(dp[j][i], dp[k][i-1] + mat[j][i]);
				}
			}
		}
		
		int max = 0;
		
//		for(int i=0; i<M; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}System.out.println();
//		}

		for(int i=0; i<M; i++) {
			max = Math.max(max, dp[i][N-1]);
		}
		System.out.println(max);
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 104ms
// 메모리 : 12484KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] adj = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				adj[i][j] = str.charAt(j*2) - '0';
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(adj[i][j] == 1) continue;
					if(adj[i][k] + adj[k][j] == 2) {
						adj[i][j] = 1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(adj[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입_사원 {
	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int ti=0; ti<T; ti++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] check = new boolean[N];
			int[][] mat = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				mat[i][0] = Integer.parseInt(st.nextToken());
				mat[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(mat, (o1, o2) -> o1[0]-o2[0]);
			
			int count = 0;
			int min = mat[0][1];
			
			for(int i=1; i<N; i++) {
				if(min < mat[i][1]) {
					count++;
				}
				else
					min = mat[i][1];
				
			}
			sb.append(N - count + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}

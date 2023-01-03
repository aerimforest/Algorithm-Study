import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별 찍기 10 {
	static int N;
	static char[][] mat;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		StringBuilder sb = new StringBuilder();
		
		func(0, 0, N, false);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(mat[i][j]);
			}sb.append("\n");
		}
		System.out.println(sb);
	}


	private static void func(int x, int y, int N, boolean isBlank) {
		
		if(isBlank) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					mat[x+i][y+j] = ' ';
				}
			}
			return;
		}
		
		if(N == 1) {
			mat[x][y] = '*';
			return;
		}
		int size = N/ 3;
		
		for(int i=0; i<3 ; i++) {
			for(int j=0; j<3; j++) {
				if(i==j && i == 1) {
					func(x + size * i, y + size * j, size, true);
				}
				else 
					func(x + size * i, y + size * j, size, false);
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new char[N][N];
		br.close();
	}
}

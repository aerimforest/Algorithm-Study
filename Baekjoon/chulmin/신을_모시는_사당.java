import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 슬라이딩 윈도우
	static int N, max;
	static int[] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		max = 0;
		int e = 0;
		int score = mat[e];
		max = Math.abs(score);
		
		// 왼쪽을 바라보는 상들 카운팅
		while(e<N) {
			if(score > 0) {
				e++;
				if(e<N)
					score += mat[e];
			}
			else if(score <= 0) {
				e++;
				if(e<N)
					score = mat[e];
			}
			max = Math.max(max, score);
		}
		
		e=0;
		score = mat[e];
		
		// 오른쪽 상을 볼때 카운팅
		while(e<N) {
			if(score <= 0) {
				e++;
				if(e<N)
					score += mat[e];
			}
			else if(score > 0) {
				e++;
				if(e<N)
					score = mat[e];
			}
			max =  Math.max(max, -1 * score);
		}
		System.out.println(max);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		mat = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			mat[i] = Integer.parseInt(st.nextToken());
			if(mat[i]==2)
				mat[i] = -1;
		}
		br.close();
	}
}

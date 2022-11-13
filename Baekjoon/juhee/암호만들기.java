import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11540ms
public class Main {

	static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[] cand = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			cand[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(cand);
		sb = new StringBuilder();
		comb(0, 0, 0, 0, new int[N], cand);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start, int mo, int ja, int[] num, char[] cand) {
		
		int N = num.length;
		int C = cand.length;
		if(N - cnt + mo == 0) return;
		if(N - cnt + ja <= 1) return;
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(cand[num[i]]);
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < C; i++) {
			num[cnt] = i;
			if(cand[i] == 'a' || cand[i] == 'e' || cand[i] == 'i' || cand[i] == 'u' || cand[i] == 'o') {
				comb(cnt+1, i+1, mo+1, ja, num, cand);
			} else {
				comb(cnt+1, i+1, mo, ja+1, num, cand);
			}
		}
	}

}

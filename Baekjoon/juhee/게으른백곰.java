import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 304ms
// 메모리 : 40628KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] map = new int[1000001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			map[loc] += g;
		}
		
		long cnt = 0;
		for (int i = 0; i <= 2 * K; i++) {
			if(i > 1000000) continue;
			cnt += map[i];
		}
		long max = cnt;
		for (int i = 2 * K + 1; i <= 1000000; i++) {
			cnt += map[i];
			cnt -= map[i - 2*K - 1];
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}

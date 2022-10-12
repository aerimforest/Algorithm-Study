import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 136ms
// 메모리 : 16348KB
public class Main {

	static int D;
	static int K;
	static int C;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(more_sushi(sushi));
	}

	private static int more_sushi(int[] sushi) {

		int N = sushi.length;
		int[] num = new int[D+1];
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			if(num[sushi[i]] == 0) cnt++;
			num[sushi[i]]++;
		}
		int max = cnt;
		if(num[C] == 0) max += 1; 
		for (int i = K; i < N + K - 1; i++) {
			if(--num[sushi[i-K]] == 0) cnt--;
			if(++num[sushi[i % N]] == 1) cnt++;
			if(num[C] == 0) max = Math.max(max, cnt+1);
			else max = Math.max(max, cnt);
		}
		return max;
	}

}

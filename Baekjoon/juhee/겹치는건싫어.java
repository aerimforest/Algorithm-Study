import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 288ms
// 메모리 : 36944KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] freq = new int[100001];
		int[] num = new int[N];
		int start = 0;
		
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int n = num[i];
			if(++freq[n] > K) {
				max = Math.max(max, i-start);
				while(start <= i) {
					if(freq[n] <= K) break;
					freq[num[start]]--;
					start++;
				}
			}
		}
		
		max = Math.max(max, N - start);
		System.out.println(max);
	}

}

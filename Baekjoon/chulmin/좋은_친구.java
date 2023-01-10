package ThisWeek23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋은_친구 {
	
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int[] cnt = new int[21];
		long answer = 0;
		
		for(int i=0; i<K; i++) {
			answer += cnt[arr[i]];
			cnt[arr[i]]++;
		}
		
		for(int i=K; i<N; i++) {
			answer += cnt[arr[i]];
			cnt[arr[i-K]]--;
			cnt[arr[i]]++;
		}
		System.out.println(answer);
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			arr[i] = line.length();
		}
		
		br.close();
	}
}

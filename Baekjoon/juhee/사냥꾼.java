import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 632ms
// 메모리 : 59500KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] gun = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(gun);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = M - 1;
			while(start <= end) {
				int mid = (start + end) / 2;
				int dist = Math.abs(gun[mid] - c) + r;
				if(dist <= L) {
					cnt++;
					break;
				} else if(gun[mid] - c > 0) {
					end = mid - 1;
				} else if(gun[mid] - c < 0) {
					start = mid + 1;
				} else {
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}

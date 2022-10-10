import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 140ms
// 메모리 : 15480KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		long start = 1;
		long end = num[N-1];
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long total = 0;
			for (int i = 0; i < N; i++) {
				total += num[i] / mid;
			}
			if(total < K) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}
}

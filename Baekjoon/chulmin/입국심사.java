import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사 {
	static int N, M, max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		long l = 0;
		long r = (long) max * M + 1;
		long answer = 0;
		
		while(l<=r) {
			long mid = (l + r) / 2;
			long count = 0;

			
			for(int i : arr) {
				count += mid / i;
			}
			if(count < M) {
				l = mid + 1;
			} else {
				r = mid - 1;
				answer = mid;
			}
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		br.close();	
	}
}

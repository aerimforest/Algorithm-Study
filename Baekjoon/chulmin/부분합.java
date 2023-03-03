
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806 {
	static int N, S, len;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		len = N + 1;
		
		int sidx = 0;
		int eidx = 0;
		
		int sum = arr[0];
		
		while(true) {
			if(sum < S) {
				eidx++;
				if(eidx == N) break;
				sum += arr[eidx];
			}
			else if(sum >=S) {
				len = Math.min(len, eidx - sidx + 1);
				sum -= arr[sidx];
				sidx++;
			}
		}
		if(len == N+1) len = 0;
		System.out.println(len);
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
}

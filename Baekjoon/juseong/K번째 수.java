import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		long lo = 1;
		long hi = K;
		
		while(lo < hi) {
			long mid = (lo + hi) / 2;	
			long count = 0;
			for(int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			if(K <= count) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		System.out.println(lo);
	}
}

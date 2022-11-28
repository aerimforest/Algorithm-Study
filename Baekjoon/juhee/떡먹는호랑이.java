import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 12384KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = K/2; i <= K; i++) {			
			int[] num = new int[D];
			num[D-1] = K;
			num[D-2] = i;
			if(check(num)) {
				System.out.println(num[0]+"\n"+num[1]);
				return;
			}
		}
	}

	private static boolean check(int[] num) {

		int len = num.length;
		for (int i = len-3; i >= 0; i--) {
			num[i] = num[i+2] - num[i+1];
			if(num[i] > num[i+1]) return false;
		}
		if(num[0] > 0 && num[1] > 0) return true;
		return false;
	}

}

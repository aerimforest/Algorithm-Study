import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 120ms
// 메모리 : 14060KB
public class Main {

	static int C;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		C = Integer.parseInt(br.readLine());
		Arrays.sort(num);
		int start = 0;
		int end = num[N-1];
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(check(mid, num)) {
				start = mid + 1;
				answer = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
	private static boolean check(int mid, int[] num) {

		int total = 0;
		for (int i : num) {
			if(i >= mid) total += mid;
			else total += i;
		}
		return total <= C;
	}

}

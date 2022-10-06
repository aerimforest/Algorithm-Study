import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 316ms
// 메모리 : 29152KB
public class Main {

	static int C;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		int start = 0;
		int end = 1000000000;
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2; // 간격
			if(check(mid, num)) { // 이 간격으로 공유기 C개를 놓을 수 있는가?
				answer = mid; // 매번 업데이트
				start = mid + 1; // 놓을 수 있다면 더 큰 간격 찾으러 가기
			} else {
				end = mid - 1; // 놓을 수 없다면 더 작은 간격 찾으러 가기
			}
		}
		System.out.println(answer);
	}

	private static boolean check(int mid, int[] num) {

		int N = num.length;
		int cnt = 1;
		int last = num[0];
		for (int i = 1; i < N; i++) {
			if(num[i] - last >= mid) {
				cnt++;
				last = num[i];
			}
		}
		return cnt >= C;
	}

}

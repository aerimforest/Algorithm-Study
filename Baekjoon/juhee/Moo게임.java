import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간 : 80ms
// 메모리 : 11504KB
public class Main {

	static char answer;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int cnt = 3;
		int total = 3;
		while(total < N) {
			cnt++;
			total += total + cnt;
		}
		
		dfs(total, cnt);
		System.out.println(answer);
	}
	private static void dfs(int total, int cnt) {

		if(N <= 3) {
			if(N == 1) answer = 'm';
			else answer = 'o';
			return;
		}
		int tmp = (total - cnt) / 2;
		if(tmp + cnt < N) {
			N -= (tmp + cnt);
			dfs(tmp, cnt - 1);
		} else if(N > tmp && N <= tmp + cnt) {
			if(N == tmp + 1) answer = 'm';
			else answer = 'o';
		} else {
			dfs(tmp, cnt - 1);
		}
	}	

}

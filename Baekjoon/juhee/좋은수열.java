import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int[] tmp = new int[N+1];
		tmp[1] = 1;
		dfs(sb, tmp, 1);
	}
	private static void dfs(StringBuilder sb, int[] tmp, int cur) {

		if(!check(tmp, cur)) {
			return;
		}
		if(cur == N+1) {
			for (int i : tmp) {
				sb.append(i);
			}
			sb.deleteCharAt(0);
			System.out.println(sb);
			System.exit(0);
		}
		tmp[cur] = 1;
		dfs(sb, tmp, cur+1);
		tmp[cur] = 2;
		dfs(sb, tmp, cur+1);
		tmp[cur] = 3;
		dfs(sb, tmp, cur+1);
	}
	private static boolean check(int[] tmp, int cur) {

		for (int i = 1; i <= cur/2; i++) {
			for (int j = 1; j < cur - (i * 2) + 1; j++) {
				boolean flag = true;
				for (int k = j; k < j+i; k++) {
					if(tmp[k] != tmp[k+i]) flag = false; 
				}
				if(flag) return false;
			}
		}
		return true;
	}

}

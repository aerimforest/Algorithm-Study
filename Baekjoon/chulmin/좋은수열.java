import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static boolean check;
	public static void main(String[] args) throws IOException {
		input();
		pro();

	}

	private static void pro() {
		check = false;
		dfs("", 0);
	}

	private static void dfs(String str, int depth) {
		if(check) return;
		if(isBad(str)) return;
		if(depth == N) {
			System.out.println(str);
			check = true;
			return;
		}
		
		for(int i=1; i<=3; i++) {
			dfs(str+i, depth+1);
		}
	}

	private static boolean isBad(String str) {
		int len = str.length();
		for(int i=0; i<len/2; i++) {
			String a = str.substring(len-1-i, len);
			String b = str.substring(len-2-2*i , len-1-i);
			if(a.equals(b)) {
				return true;
			}
		}
		return false;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, max;
	static String[] words;
	static boolean[] learned;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		learned = new boolean[26];
		// a,c,i,t,n;
		// 이미 5개를 외우고 있어야 한다.
		if(K<5) {
			System.out.println(0);
			return;
		}
		max = 0;
		learned['a'-'a'] = true;
		learned['c'-'a'] = true;
		learned['i'-'a'] = true;
		learned['t'-'a'] = true;
		learned['n'-'a'] = true;
		
		//조합
		dfs(0, 5);
		System.out.println(max);
	}

	private static void dfs(int start, int depth) {
		if(depth == K) {
			test();
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(learned[i])
				continue;
			learned[i] = true;
			dfs(i + 1, depth + 1);
			learned[i] = false;
		}
	}

	private static void test() {
		int count = 0;
		for(String s : words) {
			// 이 단어를 읽을 수 없는지 체크
			boolean check = false;
			for(char c : s.toCharArray()) {
				// 안 배운 글자다.
				if(!learned[c-'a']) {
					// 읽을 수 없다.
					check = true;
					break;
				}
			}
			// 읽을 수 있다면 세준다.
			if(!check)
				count++;
		}
		max = Math.max(max, count);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
			words[i].replaceAll("anta", "");
			words[i].replaceAll("tica", "");
		}
		
		br.close();
	}
}

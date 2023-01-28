import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<String> hs = new HashSet<>();
	static int N, M;
	static String[] A;
	public static void main(String[] args) throws IOException {
		input();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(String s : A) {
			if(hs.contains(s)) {
				count++;
				sb.append(s + "\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new String[N];
		
		for(int i=0; i<N; i++) {
			A[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			hs.add(br.readLine());
		}
		Arrays.sort(A);
		br.close();
	}
}

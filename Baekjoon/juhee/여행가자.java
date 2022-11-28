import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 92ms
// 메모리 : 13844KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.charAt(j*2) - '0' == 1) {
					union(i, j, parent);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			find(i, parent);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		for (int i = 1; i < M; i++) {
			int end = Integer.parseInt(st.nextToken())-1;
			if(parent[start] != parent[end]) {
				System.out.println("NO");
				return;
			}
			start = end;
		}
		System.out.println("YES");
		
	}

	private static void union(int i, int j, int[] parent) {

		int pi = find(i, parent);
		int pj = find(j, parent);
		
		if(pi == pj) return;
		parent[pj] = pi;
	}

	private static int find(int i, int[] parent) {

		if(i == parent[i]) return i;
		return parent[i] = find(parent[i], parent);
	}

}

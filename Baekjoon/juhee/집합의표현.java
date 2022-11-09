import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 400ms
// 메모리 : 56396KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[N+1];
		int[] rank = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(--M >= 0) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(op == 0) {
				union(a, b, parent, rank);
			} else {
				if(find(a, parent) == find(b, parent)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static void union(int a, int b, int[] parent, int[] rank) {

		int pa = find(a, parent);
		int pb = find(b, parent);
		if(pa == pb) return;
		if(rank[pa] > rank[pb]) {
			rank[pa] += rank[pb];
			parent[pb] = pa;
		} else {
			rank[pb] += rank[pa];
			parent[pa] = pb;
		}
	}

	private static int find(int b, int[] parent) {
		if(b == parent[b]) return b;
		return b = find(parent[b], parent);
	}

}

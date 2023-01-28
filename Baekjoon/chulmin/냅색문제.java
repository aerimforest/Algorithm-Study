import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, C, index;
	static int[] mat;
	static ArrayList<Integer> part1, part2;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		part1 = new ArrayList<>();
		part2 = new ArrayList<>();

		dfs(0, N/2, part1, 0);
		dfs(N/2, N, part2, 0);
		
		Collections.sort(part2);
		
		int ans = 0;
		for(int i=0; i<part1.size(); i++) {
			index = -1;
			binarySearch(0, part2.size() - 1, part1.get(i));
			ans += index + 1;
		}
		System.out.println(ans);
	}

	private static void binarySearch(int start, int end, int val) {
		if(start > end) {
			return;
		}
		int mid = (start + end) / 2;
		
		if(part2.get(mid) + val <= C) {
			index = mid;
			binarySearch(mid + 1, end, val);
		} else {
			binarySearch(start, mid -1, val);
		}
	}

	private static void dfs(int start, int end, ArrayList<Integer> part, int sum) {
		if(sum > C) {
			return;
		}
		if(start == end) {
			part.add(sum);
			return;
		}
		dfs(start + 1, end, part, sum);
		dfs(start + 1, end, part, sum + mat[start]);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		mat = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			mat[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}

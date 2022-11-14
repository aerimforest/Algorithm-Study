import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 100ms
// 메모리 : 12808KB
public class Main {

	static int total;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] people = new int[N];
		total = 0;
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total += people[i];
		}
		
		List<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				list[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		min = Integer.MAX_VALUE;
		subset(1, new boolean[N], list, people);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	private static void subset(int cnt, boolean[] v, List<Integer>[] list, int[] people) {

		int N = v.length;
		if(cnt == N) {
			if(related(v, list)) {
				int sum = 0;
				for (int i = 0; i < N; i++) {
					if(v[i]) sum += people[i];
				}
				min = Math.min(Math.abs(sum - (total - sum)), min);
			}
			return;
		}
		
		v[cnt] = true;
		subset(cnt+1, v, list, people);
		v[cnt] = false;
		subset(cnt+1, v, list, people);
	}
	private static boolean related(boolean[] v, List<Integer>[] list) {

		int N = v.length;
		Queue<Integer> que = new LinkedList<>();
		que.offer(0);
		boolean[] tmp = new boolean[N];
		tmp[0] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int b : list[cur]) {
				if(v[b]) continue;
				if(tmp[b]) continue;
				tmp[b] = true;
				que.offer(b);
			}
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) {
				que.offer(i);
				tmp[i] = true;
				break;
			}
		}
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int b : list[cur]) {
				if(!v[b]) continue;
				if(tmp[b]) continue;
				tmp[b] = true;
				que.offer(b);
			}
		}
		for (int i = 0; i < N; i++) {
			if(!tmp[i]) return false;
		}
		return true;
	}

	

}

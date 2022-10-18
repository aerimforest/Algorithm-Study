import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] student = new int[N];
		List<Integer>[] bigger = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			bigger[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken())-1;
			int big = Integer.parseInt(st.nextToken())-1;
			bigger[small].add(big);
			student[big]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			if(student[i] == 0) que.offer(i);
		}
		
		for (int i = 0; i < N; i++) {
			int n = que.poll();
			sb.append(n+1).append(" ");
			for (Integer b : bigger[n]) {
				if(--student[b] == 0) {
					que.offer(b);
				}
			}
		}
		
		System.out.println(sb);
	}


}

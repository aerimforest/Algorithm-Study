import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] labber = new int[101];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			labber[start] = end;
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			labber[start] = end;
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {1, 0});
		boolean[] v = new boolean[101];
		int answer = -1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == 100) {
				answer = cur[1];
				break;
			}
			for (int i = 1; i <= 6; i++) {
				if(cur[0] + i >= 101) continue;
				if(v[cur[0]+i]) continue;
				v[cur[0]+i] = true;
				if(labber[cur[0] + i] != 0) que.offer(new int[] {labber[cur[0] + i], cur[1]+1});
				else que.offer(new int[] {cur[0] + i, cur[1] + 1});
			}
		}
		System.out.println(answer);
	}

}

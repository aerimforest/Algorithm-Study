import java.io.*;
import java.util.*;

// BOJ_12852

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] visit = new int[n+1][2];
		
		Queue<Integer> q = new LinkedList<>();
		visit[n][0] = 1;
		visit[n][1] = n;
		q.add(n);
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 1) {
				break;
			}
			
			if(cur%3 == 0 && visit[cur/3][0] == 0) {
				visit[cur/3][0] = visit[cur][0] + 1;
				visit[cur/3][1] = cur;
				q.add(cur/3);
			}
			if(cur%2 == 0 && visit[cur/2][0] == 0) {
				visit[cur/2][0] = visit[cur][0] + 1;
				visit[cur/2][1] = cur;
				q.add(cur/2);
			}
			if(visit[cur-1][0] == 0) {
				visit[cur-1][0] = visit[cur][0] + 1;
				visit[cur-1][1] = cur;
				q.add(cur-1);
			}
		}
		
		ArrayList answer = new ArrayList<>();
		int x = 1;
		while(x != n) {
			answer.add(x);
			x = visit[x][1];
		}
		answer.add(n);
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()-1).append("\n");
		for(int i = answer.size()-1; i >= 0; i--) {
			sb.append(answer.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}

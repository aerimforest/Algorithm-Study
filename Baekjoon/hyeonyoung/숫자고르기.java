import java.io.*;
import java.util.*;

// BOJ_2668

public class Main {
	static ArrayList<Integer> answer = new ArrayList<>();
	static int[] arr = new int[101];
	static int[] visit = new int[101];

	static void dfs(int cur) {
		if(visit[cur] == 0) {
			visit[cur] = 1;
			int next = arr[cur];
			if(visit[next] != 2) {
				dfs(next);
			}
			visit[cur] = 2;
		}
		else if(visit[cur] == 1) {
			visit[cur] = 2;
			answer.add(cur);
			int next = arr[cur];
			if(visit[next] != 2) {
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= n; i++) {
			if(visit[i] == 0) {
				dfs(i);
			}
		}
		
		sb.append(answer.size() + "\n");
		answer.sort(null);
		for(int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i) + "\n");
		}
		System.out.println(sb);
	}
}

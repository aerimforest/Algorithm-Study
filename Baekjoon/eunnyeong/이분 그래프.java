import java.io.*;
import java.util.*;

public class Main {
	
	static int[] visit;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < n; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list = new ArrayList[v + 1];
			
			for (int i = 0; i < v + 1; i++)
				list[i] = new ArrayList<>(); 
			
			for (int i = 0; i < e; i++) {//간선 연결
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			visit = new int[v + 1]; //1 or 2
			for (int i = 1; i <= v; i++)
				if (visit[i] == 0) //방문하지 않은 정점 방문하며 체크
					dfs(i);
			
			if (check(v))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		
		System.out.println(sb);
 	}
	
	public static void dfs(int s) {
		if (visit[s] == 0) visit[s] = 1;
		
		for (int i = 0; i < list[s].size(); i++) {
			int x = list[s].get(i);
			if (visit[x] == 0) { //방문하지 않았을 때
				if (visit[s] == 1) visit[x] = 2; //인접 정점을 서로 다른 색으로 칠해줌
				else if (visit[s] == 2) visit[x] = 1;
				dfs(x);
			}
		}
	}
	
	public static boolean check(int v) {
		for (int i = 1; i <= v; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				int x = list[i].get(j);
				if (visit[i] == visit[x]) return false; //인접정점의 색이 같다면 이분 그래프 아님
			}
		}
		return true;
	}
}

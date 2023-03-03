import java.util.*;
import java.io.*;

//문제요약
// 세로 두 줄, 가로로 N개의 칸
// 	첫째줄 : 정수 1,2 , ... , N
// 	둘째줄 : 1이상 N이하 정수

// 첫째줄에서 숫자를 적절히 뽑아, 
// 둘째줄의 정수들과 집합이 일치하는 최대 경우의 수 & 뽑은 수 출력

// 해결방법 (시간제한 1초, 1 ≤ N ≤ 100 )
// 그래프 문제 !?
// 첫째줄 i번에서 출발해서, 둘째줄 j번을 따라가다 다시 i번에 왔다면 => 싸이클 생성

public class Main{

	static int N, ans;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = stoi(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		for(int i = 1 ; i<N+1; i ++) arr[i] = stoi(br.readLine());
		
		// 1부터 N번까지 싸이클 형성되었는 지 확인
		for(int i=1;i<N+1;i++){
			visited[i] = true;
			DFS(i,arr[i]);
			visited[i] = false;
		}

		System.out.println(ans);
		System.out.println(sb.toString());
	}
	
	public static void DFS(int start, int nxt){
		// 시작 지점을 사전에 방문하였고, 재방문 하였을 때
		if(visited[nxt] && start == nxt){ 
			sb.append(start+"\n"); //뽑힌 정수
			ans += 1 ; //전체 경우의 수
			return;
		}
		
		// 다음 지점을 방문하지 않았을 때, 탐색
		if(!visited[nxt]){
			visited[nxt] = true ;
			DFS(start,arr[nxt]);
			visited[nxt] = false ;
		}

	}
}

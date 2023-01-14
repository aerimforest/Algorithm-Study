import java.util.*;
import java.io.*;

public class Main{

	static int N; // 전체 학생 수
	static int ans = 0; // 형성된 팀들의 학생 수
	static int[] arr; // i번째 학생이 선택한 학생 배열
	static boolean[] visited; // 방문 확인
	static boolean[] finished; // DFS 검사 끝 확인

	public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());

		for(int t=0;t<TestCase;t++){
			// 값 입력 -->
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			finished = new boolean[N+1];
			visited = new boolean[N+1];
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
			// <--

			// 각 학생마다 싸이클 확인
			for(int i=1;i<N+1;i++){
				DFS(i);
			}

			System.out.println(N-ans);
		}
	}

	public static void DFS(int x){
		if(finished[x]) return; // DFS 탐색을 했었던 경우 return
		if(visited[x]){// DFS 탐색이 끝나기 전, visited[x] = true 라면 재방문인 경우이므로 ans += 1;
			finished[x] = true;
			ans ++;
		}
		visited[x] = true;
		DFS(arr[x]);
		finished[x] = true;
	}

}

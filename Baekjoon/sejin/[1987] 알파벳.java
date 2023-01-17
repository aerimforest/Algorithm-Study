import java.util.*;
import java.io.*;

// 문제 요약
// (0,0)에서 출발하여 알파벳을 중복하지 않고 말이 최대로 갈 수 있는 칸 수 출력

// 해결 방법
// DFS 탐색
	// 상하좌우로 이동하며 알파벳탐색
	// 중복 방문은 불가하므로, 방문한 알파벳은 visited= true 를 해준다.
	// 여기서 visited는 알파벳의 개수가 26개 이므로, new boolean[26] 으로 생성하여 처리

public class Main{

	static int R, C; // R개의 줄 , C개의 대문자 알파벳
	static int[][] arr; // 알파벳 배열
	static boolean[] visited; // 알파벳 개수 = 26개, 방문한 알파벳 순서에 visited 로 표시
	static int[] dx = {-1,0,1,0}, dy={0,1,0,-1}; // 상하좌우 방향벡터
	static int MaxResult = Integer.MIN_VALUE ; // 정답, 최대로 갈 수 있는 칸 계산

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visited = new boolean[26];

		for(int i=0;i<R;i++){
			char[] input = br.readLine().toCharArray();
			for(int j=0;j<C;j++){
				arr[i][j] = input[j] - 'A' ;
			}
		}
		//<--

		DFS(0,0,1); // 좌측 상단 출발
		System.out.println(MaxResult);
	}

	public static void DFS(int x, int y, int count){
		MaxResult = Math.max(MaxResult, count);
		visited[arr[x][y]] = true; // 현재 알파벳 방문 확인 처리
		for(int i=0;i<4;i++){
			int xx = x+dx[i];
			int yy = y+dy[i];
			if( xx <0 || xx>=R || yy<0 || yy>=C || visited[arr[xx][yy]]) continue;
			DFS(xx,yy,count+1);
		}
		visited[arr[x][y]] = false; // 현재 알파벳 방문 확인 해제!!
	}
}

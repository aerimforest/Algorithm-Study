import java.util.*;
import java.io.*;

// 문제 요약
// 1. 주어진 맵에서, 1은 집이 있는 곳 0 은 집이 없는 곳이다.
// 2. 상하좌우로 붙어있는 1들 끼리를 단지로 칭함
// 3. 맵에서 단지의 개수를 구해야 함.

// 해결 방법
// 1. 1이고, 방문하지 않았을 때 DFS

public class Main{

	static int N; // N : 맵의 크기
	static int count = 0; // 각 단지 내 집의 개수 저장할 변수
	static int[][] arr; // 맵 입력값
	static boolean[][] visited ; // 방문 확인
	static int[] dx = {-1,0,1,0}, dy={0,-1,0,1}; // 상하좌우 탐색
	static ArrayList<Integer> result; // 각 단지에 속하는 집의 수를 저장 후 오름차순으로 출력하기 위함

	public static void main(String args[]) throws Exception{
		// 값 입력 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		result = new ArrayList<>();
		
		for(int i=0;i<N;i++){
			char[] input = br.readLine().toCharArray();
			for(int j=0;j<N;j++){
				arr[i][j] = input[j]-'0';
			}
		}
		// 값 입력 <-- 

		// 탐색 시작
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j] == 1 && !visited[i][j]){ // 1이고 방문하지 않았을 때
					count = 1; // 집의 개수 : 현재 arr[i][j] = 1개
					DFS(i,j); 
					result.add(count); // DFS 후 단지 내 집의 개수 더해줌
				}
			}
		}
		Collections.sort(result); // 오름차순
		System.out.println(result.size());
		for(int i:result)System.out.println(i);
	}


	public static void DFS(int x, int y){
		visited[x][y] = true;

		for(int i=0;i<4;i++){
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx<0 || xx>=N || yy<0 || yy>=N || visited[xx][yy] || arr[xx][yy] == 0) continue;
			if(arr[xx][yy] == 1) {
				DFS(xx,yy);
				count += 1;
			}
		}
		
	}
}

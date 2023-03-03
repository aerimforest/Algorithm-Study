import java.util.*;
import java.io.*;

// 문제 요약
// 5×5 격자 모양 가마에 서로 다른 재료 3개를 순서대로 넣어 최고 품질의 폭탄 생성

// 재료구성
	// 4x4 모양
	// 1. 효능 : 가마 한 칸의 품질을 바꾸는 정수 ( -9 ~ 9 )
	// 2. 원소 : 가마 한 칸의 원소를 바꿀 수 있는 색 (빨강 'R', 파랑 'B', 초록 'G', 노랑 'Y', 흰색 'W')

// 재료 가마에 넣는 방법
	// 넣기
		// 회전 가능 (재료를 넣을 때 5x5 격자를 벗어날 수 없음)
		
	// 변화
		// 현재칸 가마품질 + 재료 효능 = 음수?0, 9초과? 9
		// 현재칸 색 = 재료의 원소 흰색?흰색, 아닌경우 원소의 색

// 폭탄 만드는 방법
	// (폭탄의 품질) = 7R + 5B + 3G + 2Y

// 해결 방법 ( 시간제한 3초, 3<= N <= 10 (N:재료) )
// 시간복잡도, 알고리즘 생각
	// 최대 10개의 재료에서, 서로 다른 3개의 재료를 넣고  => 10*9*8
	// N개 중 3개 회전 => 1개 회전 N^2  = 16 , 3번 해야하므로 ^3

	// 3초면 충분히 하고도 남을 시간인 듯 하오니
	// -> 완전탐색 + DFS 다!

// 재료를 저장하는데 (재료의 위치), (효능) (원소)  어떤 자료구조를 써야할까
	// 3차원 배열 ..?, 어레이리스트...? 효능,원소 두 개 따로..?
	// int[][][] , ArrayList<Node>, int[][] [][]
	// -> 클래스를 생성한 3차원 배열!

// 재료를 회전
	// arr2[i][j] = arr[N-1-j][i] ; 90도 회전, 2중 반복문 

public class Main{

	static int N ; // 재료의 개수
	static int[][] map ; // 가마
	static Info[][][] materials;
	static boolean[] visited;
	static int ans = -1000000;

	static class Info{ // 재료들의 정보를 저장할 클래스
		int effects;
		char color;
		public Info(int effects, char color){
			this.effects = effects;
			this.color = color;
		}

		public String toString(){
			return "" + effects + " , " + color ;
		}
	}


	// 문자열을 정수로 변환
	public static int stoi(String str){ 
		return Integer.parseInt(str);
	} 

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		materials = new Info[N][4][4];
		visited = new boolean[N];
		Info[][] map = new Info[5][5];

		// 맵 기본값 설정 -->
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				map[i][j] = new Info(0, 'W');
			}
		}
		// <--

		// N개의 재료가 들어옴 -->
		for(int i=0; i<N; i++){ 
			StringTokenizer st;
			// 1. 효능, 정수 정보
			for(int j=0;j<4;j++){
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++){
					materials[i][j][k] = new Info(0,'W');
					materials[i][j][k].effects = stoi(st.nextToken());
				}
			}

			// 2. 원소, 색 정보
			for(int j=0;j<4;j++){
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++){
					materials[i][j][k].color = st.nextToken().charAt(0);
				}
			}
		}
		// <-- 

		BackTracking(map,0);

		// print1(map);
		// print2(materials);
		System.out.println(ans);
	}

	public static void BackTracking(Info[][] map, int count){
		if(count == 3 ){ //재료 3개일 때 return
			ans = Math.max(ans , score(map));
			return;
		}

		for(int idx = 0; idx<N; idx++){
			if(visited[idx]) continue;
			visited[idx] = true;
			first:for(int i=0;i<2;i++){
				for(int j=0;j<2;j++){
					if(count == 0 && j>0) break first;
					for(int dir=0;dir<4;dir++){
						Info[][] newMap = copy(map);
						putMaterial(newMap, idx, i, j, dir);
						BackTracking(newMap, count+1);
					}
				}
			}
			visited[idx] = false;
		}

	}

	public static void putMaterial(Info[][] map, int idx, int r , int c, int dir ){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(dir == 0){ // 0도
					map[i+r][j+c].effects += materials[idx][i][j].effects;
					if(map[i+r][j+c].effects<0)map[i+r][j+c].effects = 0; // 음수인 경우 0
					else if(map[i+r][j+c].effects>9)map[i+r][j+c].effects = 9; // 9 이상일 때 9
					if(materials[idx][i][j].color == 'W') continue; // 재료가 W 색인 경우만 제외하고
					map[i+r][j+c].color = materials[idx][i][j].color; // 재료 색으로 변경
				}else if(dir == 1 ){ //90도 회전
					map[i+r][j+c].effects += materials[idx][j][3-i].effects;
					if(map[i+r][j+c].effects<0)map[i+r][j+c].effects = 0; // 음수인 경우 0
					else if(map[i+r][j+c].effects>9)map[i+r][j+c].effects = 9; // 9 이상일 때 9
					if(materials[idx][j][3-i].color == 'W') continue; // 재료가 W 색인 경우만 제외하고
					map[i+r][j+c].color = materials[idx][j][3-i].color; // 재료 색으로 변경
				}else if(dir == 2 ){ //180도 회전
					map[i+r][j+c].effects += materials[idx][3-i][3-j].effects;
					if(map[i+r][j+c].effects<0)map[i+r][j+c].effects = 0; // 음수인 경우 0
					else if(map[i+r][j+c].effects>9)map[i+r][j+c].effects = 9; // 9 이상일 때 9
					if(materials[idx][3-i][3-j].color == 'W') continue; // 재료가 W 색인 경우만 제외하고
					map[i+r][j+c].color = materials[idx][3-i][3-j].color; // 재료 색으로 변경
				}else{ // 270도 회전
					map[i+r][j+c].effects += materials[idx][3-j][i].effects;
					if(map[i+r][j+c].effects<0)map[i+r][j+c].effects = 0; // 음수인 경우 0
					else if(map[i+r][j+c].effects>9)map[i+r][j+c].effects = 9; // 9 이상일 때 9
					if(materials[idx][3-j][i].color == 'W') continue; // 재료가 W 색인 경우만 제외하고
					map[i+r][j+c].color = materials[idx][3-j][i].color; // 재료 색으로 변경
				}
			}
		}
	}

	// (폭탄의 품질 구하는 함수) = 7R + 5B + 3G + 2Y
	public static int score(Info[][] map){
		int sum = 0 ;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				int s = 0;
				Info now = map[i][j]; // 현재 맵
				switch(now.color){
					case 'R': 
						s = 7 ; // 7R
						break;
					case 'B':
						s = 5 ; // 5B
						break;
					case 'G':
						s = 3 ; // 3G
						break;
					case 'Y':
						s = 2 ; //2Y
						break;
				}
				sum += s * now.effects; // + 
			}
		}
		return sum;
	}

	public static Info[][] copy(Info[][] map){ // 깊은 복사
		Info[][] newmap = new Info[5][5];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				newmap[i][j] = new Info(map[i][j].effects, map[i][j].color);
			}
		}
		return newmap;
	}

	public static void print1(Info[][] x ){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(x[i][j].toString() + " | ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
	
	public static void print2(Info[][][] x){
		for(int i=0;i<N;i++){
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					System.out.print(x[i][j][k].toString() + " | ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}

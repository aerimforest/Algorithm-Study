import java.io.*;
import java.util.*;

//문제요약

// 연구소 N×N 
// 연구소는 빈 칸 (0), 벽(1), 바이러스(2)로 이루어짐
	// 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성->활성
	// 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제, 1초 소요

// 승원이는 연구소의 바이러스 M개를 활성 상태로 변경할 때 
	// 연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력
	// 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우 -1 출력

// 해결방법 (시간제한 0.25초 )
// 연구소의 크기 N(4 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(1 ≤ M ≤ 10)
// 완전탐색

public class Main{

	static class Virus{
		int x,y,time;
		Virus(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N,K;
	static int[][] arr;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1}; // 상하좌우

	static List<Virus> viruses = new ArrayList<>();
	static Virus[] active; // K개의 활성 바이러스
	static int MinTime = Integer.MAX_VALUE; // 정답, 최솟값 구해야 함
	static int ZeroCnt = 0 ; // 비활성 바이러스 개수

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		arr = new int[N][N];
		active = new Virus[K];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				int now = stoi(st.nextToken());
				arr[i][j] = now ;
				if(now == 0) ZeroCnt ++ ;
				else if (now == 2) viruses.add(new Virus(i,j,0));
			}
		}
		// <--

		if(ZeroCnt == 0) System.out.println(0); // 비활성 바이러스가 없는 경우
		else{
			selectVirus(0,0);
			System.out.println(MinTime == Integer.MAX_VALUE? -1 : MinTime);
		}
	}

	// K개의 바이러스를 다른 경우로 생성
	public static void selectVirus(int start, int cnt){ 
		if(cnt == K ){ // K개가 되었을 때, 감염 시작
			infectVirus(ZeroCnt);
			return;
		} 

		// 서로 다른 K개의 경우 생성
		for(int i=start;i<viruses.size();i++){
			active[cnt] = viruses.get(i);
			selectVirus(i+1, cnt+1);
		}

	}

	// BFS로 감염 시작
	public static void infectVirus(int zeroSpace){

		Queue<Virus> q = new LinkedList<>();
		boolean[][] infected = new boolean[N][N];
	
		// 활성화된 K개의 바이러스들의 좌표를 Q에 삽입
		for(int i=0;i<K;i++){
			Virus virus = active[i];
			infected[virus.x][virus.y] = true;
			q.add(virus);
		}

		while(!q.isEmpty()){
			Virus virus = q.poll();
			for(int i=0;i<4;i++){
				int xx = virus.x + dx[i];
				int yy = virus.y + dy[i];

				if(xx<0 || xx>=N || yy<0 || yy>=N ) continue; // out of range
				if(infected[xx][yy] || arr[xx][yy] == 1) continue; // 방문했거나 || 벽인 경우
				if(arr[xx][yy] == 0 ) zeroSpace -- ; // 감염됨
				if(zeroSpace == 0){ // 전체 감염인 경우
					MinTime = Math.min(MinTime, virus.time + 1);
					return;
				}

				infected[xx][yy] = true;
				q.add(new Virus(xx, yy, virus.time + 1));
			}
		}
	}
}

// 배운 것
// 전체 감염 되었는 지 확인할 때 , 반복문으로 확인했었는데
// 이렇게 ZeroCnt 라는 변수를 사용할 수 있다는 걸 배웠다!
// 그리고 K개의 바이러스들이 동시에 감염되는 걸 어떻게 구현하나 했는데 큐에 넣으면 되는 것 이었다

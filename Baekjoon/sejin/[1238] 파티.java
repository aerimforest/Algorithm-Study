import java.util.*;
import java.io.*;

// 문제요약
// N명의 학생이 X번 마을에 모여 파티 진행
// 마을 사이 M개의 단방향 도로, i번째 길 T 의 시간
// N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생 ( 최단 시간 )

// 나의 해결방법 ( 시간제한 1초,  N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000))
// 가는 거 계산
// 	X마을까지 다익스트라 실행
// 	O(N-1)*(MlogN)
// 오는 거 계산
// 	X마을부터 다익스트라 실행
// 	O(MlogN)

// 더 나은 해결방법
// 배열을 입력받을 때, arr[start][end] 로 입력받기만 했었는데
// arr[end][start] 로도 입력받아서, 갔다 왔다를 다익스트라 2번만 돌려주면 된다...!!

class Node{
	int idx,cost;
	Node(int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main{

	static int N,M,X ; // N: 학생수, M : 도로수, X: X번 마을에서 모임
	static ArrayList<Node>[] map, ReMap; // 원래 맵, 반대맵

	public static int stoi(String str){
		return Integer.parseInt(str);
	}
	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		X = stoi(st.nextToken())-1;
		map = new ArrayList[N];
		ReMap = new ArrayList[N];

		for(int i=0;i<N;i++) {
			map[i] = new ArrayList();
			ReMap[i] = new ArrayList();
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken())-1;
			int y = stoi(st.nextToken())-1;
			int cost = stoi(st.nextToken());
			map[x].add(new Node(y,cost));
			ReMap[y].add(new Node(x,cost));
		}
		//<--

		
		int[] ComeDist = dijkstra(map); // 오는 거
		int[] GoDist = dijkstra(ReMap); // 가는 거

		int ans = 0 ;
		for(int i=0;i<N;i++){ // 최댓값 계산
			if(i==X) continue;
			ans = Math.max(ans, ComeDist[i] + GoDist[i]);
		}

		System.out.println(ans);
	}

	public static int[] dijkstra(ArrayList<Node>[] arr){
		PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
		pq.offer(new Node(X, 0)); // 시작 정점 삽입
		
		int[] dist = new int[N+1]; // 거리 배열 초기화
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[X] = 0;

		while(!pq.isEmpty()){ // 최단경로 계산
			Node now = pq.poll();
			int cur = now.idx;
			for(Node nxt : arr[cur]){
				if(dist[nxt.idx] < now.cost) continue;
				if(dist[nxt.idx] > now.cost + nxt.cost){
					dist[nxt.idx] = now.cost + nxt.cost;
					pq.offer(new Node(nxt.idx, dist[nxt.idx]));
				}
			}
		}
		return dist;
	}
}

import java.io.*;
import java.util.*;

// 유향그래프
// 간선 : 강 , 간선방향 : 물 방향 , 노드 :  호수나 샘처럼 강이 시작하는 곳, 강이 합쳐지거나 나누어지는 곳, 바다와 만나는 곳

// 시간제한 1초 , (2 ≤ M ≤ 1000) (1 ≤ A, B ≤ M)
// K,M,P 
// K는 테스트 케이스 번호, M은 노드의 수, P는 간선의 수
// P개의 줄에 간선의 정보를 나타내는 A,B = A에서 B로 물이 흐른다
// M 은 항상 바다와 만나는 노드, 밖으로 향하는 간선은 존재하지 않음

public class Main{

	static int K, M, P ;
	static ArrayList<Integer>[] graph ;
	static int[] strahler, RiverCount, order ; 

	static Queue<Integer> q ; 
	static int count = 0 ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TestCase = stoi(br.readLine());

		for(int t=0;t<TestCase;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = stoi(st.nextToken());
			M = stoi(st.nextToken());
			P = stoi(st.nextToken());

			graph = new ArrayList[M+1]; // 노드와 간선의 관계 그래프
			strahler = new int[M+1]; // 각 노드의 진입차수
			RiverCount = new int[M+1] ; // 해당 노드로 들어오는 강의 수
			order = new int[M+1]; // 진입순서

			for(int i=0;i<M+1;i++) graph[i] = new ArrayList<>();

			for(int i=0;i<P;i++){
				st = new StringTokenizer(br.readLine());
				int a = stoi(st.nextToken()) ;
				int b = stoi(st.nextToken());
				graph[a].add(b);
				strahler[b] += 1 ;
			}

			Topology();
			System.out.println(K + " " + count);

		}
	}

	public static void Topology(){

		q = new LinkedList<>() ; 
		count = 0 ;

		for(int i=1;i<=M;i++) {
			if(strahler[i] == 0){
				q.add(i);
				order[i]++;
				RiverCount[i] ++ ;
			}
		}

		while(!q.isEmpty()){
			int idx = q.poll();
			if(RiverCount[idx] >= 2) order[idx] ++ ; // 들어오는 강이 2개 이상이면 순서 증가
			count = Math.max(count,order[idx]);

			for(int now : graph[idx]){
				strahler[now] -- ; // 간선 정보 삭제
				if(strahler[now] == 0) q.add(now); 
				if(order[now] == order[idx]) RiverCount[now] ++ ;
				else if (order[now] < order[idx]){
					order[now] = order[idx];
					RiverCount[now] = 1 ;
				}
			}
		}


	}

}

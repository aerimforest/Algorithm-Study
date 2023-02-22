import java.io.*;
import java.util.*;

public class Main {

	static int N, M ; // 도시의 수, 여행 계획에 속한 도시의 수
	static ArrayList<Integer>[] graph ;
	static int[] travelCities; 
	static boolean[] visitCities; 
 
	public static void main(String[] args) throws IOException {
		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		N = Integer.parseInt(br.readLine()); 
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		visitCities = new boolean[N];
		travelCities = new int[M];
		for(int i=0;i<N;i++) graph[i] = new ArrayList();

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				int now = Integer.parseInt(st.nextToken()); 
				if(now == 1) graph[i].add(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) travelCities[i] = Integer.parseInt(st.nextToken())-1; 
		// <--

		travel(travelCities[0]);
		
		boolean ans = true ;
		for(int i=0;i<M;i++){
			if(!visitCities[travelCities[i]]){
				ans = false;
				break;
			}
		}
		System.out.println(ans ? "YES":"NO");
	}

	public static void travel(int start){
		visitCities[start] = true;

		for(int nxt : graph[start]){
			if(!visitCities[nxt]){
				travel(nxt) ;
			}
		}

	}
}

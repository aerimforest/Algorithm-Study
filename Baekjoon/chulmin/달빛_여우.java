import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 달빛_여우 {
	static int N;
	static int[] disF;
	static int[][] disW;
	static ArrayList<int[]>[] list;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		dijkFox();
		
//		for(long i: disF) {
//			System.out.print(i + " ");
//		}System.out.println();
		
		dijkWolf();
//		for(long i: disW[0]) {
//			System.out.print(i + " ");
//		}System.out.println();
//
//		for(long i: disW[1]) {
//			System.out.print(i + " ");
//		}System.out.println();
		
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(disF[i] < Math.min(disW[0][i], disW[1][i]))
				count++;
		}
		System.out.println(count);
	}

	// 다익스트라 늑대
	private static void dijkWolf() {
		
		disW = new int[2][N+1];
		Arrays.fill(disW[0], Integer.MAX_VALUE);
		Arrays.fill(disW[1], Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0, 0));
		disW[0][1] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.idx;
			int weight = cur.weight;
			int isD = cur.isD;
			
			if(disW[isD][idx] < weight)
				continue;

			int nD = 1 - isD;
			for(int[] next : list[idx]) {
				int cost = disW[isD][idx] + ((isD == 0) ? next[1] / 2 : next[1] * 2);
				
				if(disW[nD][next[0]] > cost) {
					disW[nD][next[0]] = cost;
					pq.add(new Node (next[0], cost, nD));
				}
			}
		}
	}
	
	// 다익스트라 은빛 여우
	private static void dijkFox() {
		
		disF = new int[N+1];
		Arrays.fill(disF, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		pq.add(new Node (1, 0));
		disF[1] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = (int) cur.idx;
			int weight = cur.weight;
			
			if(disF[idx] < weight)
				continue;
			
			for(int[] next : list[idx]) {
				if(disF[next[0]] > disF[idx] + next[1]) {
					disF[next[0]] = disF[idx] +next[1];
					pq.add(new Node (next[0], disF[next[0]]));
				}
			}
		}
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++)
			list[i] = new ArrayList<int[]>();
			
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) * 2;
			
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
			
		br.close();
	}
}

class Node implements Comparable<Node>{
	int idx, weight, isD;
	
	public Node(int idx, int weight) {
		this.idx = idx;
		this.weight = weight;
	}
	
	public Node(int idx, int weight, int isD) {
		this.idx = idx;
		this.weight = weight;
		this.isD = isD;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

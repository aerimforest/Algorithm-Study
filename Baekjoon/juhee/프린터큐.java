package _202210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐_실버3 {

	static class Node implements Comparable<Node>{
		int value;
		int index;
		
		public Node (int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		@Override
		public int compareTo(Node o) {
			int n = o.value - this.value;
			if(n != 0) return n;
			else return this.index - o.index;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			PriorityQueue<Node> pq = new PriorityQueue<>();
			Queue<Node> que = new LinkedList<>();
			int loc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				pq.offer(new Node(n, i));
				que.offer(new Node(n, i));
			}
			
			int time = 1;
			while(!pq.isEmpty()) {
				Node cur = pq.peek();
				Node del = que.poll();
				if(cur.value == del.value) {
					if(del.index == loc) break;
					pq.poll();
					time++;
				} else {
					que.offer(del);
				}
			}
			sb.append(time).append("\n");
		}
		System.out.println(sb);
	}

}

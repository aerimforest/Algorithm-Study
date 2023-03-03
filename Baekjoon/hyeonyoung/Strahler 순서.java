import java.io.*;
import java.util.*;

// BOJ_9470

class Node{
	int cur, max, cnt;
	
	Node(int cur, int max, int cnt){
		this.cur = cur;
		this.max = max;
		this.cnt = cnt;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			line = br.readLine().split(" ");
			int k = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int p = Integer.parseInt(line[2]);
			
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(m+1);
			ArrayList<Node> inorder = new ArrayList<>(m+1);
			for(int i = 0; i <= m; i++) {
				adj.add(new ArrayList<>());
				inorder.add(new Node(0,0,0));
			}
			
			for(int i = 0; i < p; i++) {
				line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				
				adj.get(a).add(b);
				inorder.get(b).cur++;
			}
			
			int[] strahler = new int[m+1];
			Queue<Node> queue = new LinkedList<>();
			for(int i = 1; i <= m; i++) {
				if(inorder.get(i).cur == 0) {
					inorder.get(i).cur = i;
					inorder.get(i).cnt = 10;
					queue.add(inorder.get(i));
				}
			}
			
			while(!queue.isEmpty()) {
				int cur = queue.peek().cur;
				int max = queue.peek().max;
				int cnt = queue.peek().cnt;
				queue.remove();
				
				if(cnt >= 2) {
					strahler[cur] = max+1;
				}
				else {
					strahler[cur] = max;
				}
				
				for(int next : adj.get(cur)) {
					Node node = inorder.get(next);
					if(node.max < strahler[cur]) {
						node.max = strahler[cur];
						node.cnt = 1;
					}
					else if(node.max == strahler[cur]) {
						node.cnt++;
					}
					
					if(--node.cur == 0) {
						node.cur = next;
						queue.add(node);
					}
				}
			}
						
			sb.append(k).append(" ").append(strahler[m]).append("\n");
		}
		System.out.println(sb);
	}
}

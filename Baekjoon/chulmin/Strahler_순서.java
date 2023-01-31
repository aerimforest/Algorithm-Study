import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int ti=1; ti<=T; ti++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			Node9470[] nodeArr = new Node9470[M+1];
			int[] inCnt = new int[M+1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			
			for(int i=0; i<=M; i++) {
				nodeArr[i] = new Node9470(i, 0, 0);
				list.add(new ArrayList<Integer>());
			}
			
 			for(int i=0; i<P; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				list.get(A).add(B);
				inCnt[B]++;
			}
 			
 			Queue<int[]> queue = new LinkedList<int[]>();
 			
 			for(int i=1; i<=M; i++) {
 				if(inCnt[i]==0)
 					queue.add(new int[] {i, 1});
 			}
 			while(!queue.isEmpty()) {
 				int[] cur = queue.poll();
 				
 				if(cur[0]==M) break;
 				for(int next : list.get(cur[0])) {
 					if(nodeArr[next].max < cur[1]) {
 						nodeArr[next].max = cur[1];
 						nodeArr[next].cnt = 1;
 					} else if(nodeArr[next].max == cur[1])
 						nodeArr[next].cnt++;
 					if(--inCnt[next]==0) {
 						if(nodeArr[next].cnt > 1) nodeArr[next].max++;
 						queue.add(new int[] {next, nodeArr[next].max});
 					}
 				}
 			}
 			sb.append(ti + " " + nodeArr[M].max + "\n");
		}	
		System.out.println(sb);
		br.close();
	}
}
class Node9470 {
	int num, max, cnt;
	public Node9470(int num, int max, int cnt) {
		this.num=num;
		this.max=max;
		this.cnt=cnt;
	}
}

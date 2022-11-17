import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 680ms
// 메모리 : 74868KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> teach = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			teach.offer(new int[] {start, end});
		}
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		que.offer(0);
		while(!teach.isEmpty()) {
			if(que.peek() > teach.peek()[0]) {
				que.offer(teach.poll()[1]);
			} else {
				que.poll();
				que.offer(teach.poll()[1]);
			}
		}
		System.out.println(que.size());
	}

}

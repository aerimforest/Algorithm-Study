import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Sugang[] sugangs = new Sugang[N];
		
		//우선큐
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sugangs[i] = new Sugang(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(sugangs, 
							new Comparator<Sugang>() {

								@Override
								public int compare(Sugang o1, Sugang o2) {
									
									return o1.start - o2.start;
								}
		});
		
		queue.add(sugangs[0].end);
		
		for (int i = 1; i < N; i++) {
			if (queue.peek() <= sugangs[i].start) {
				queue.poll();
			}
			queue.add(sugangs[i].end);
		}
		
		System.out.println(queue.size());
	}
	
	static class Sugang {
		int start;
		int end;
		
		public Sugang(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}

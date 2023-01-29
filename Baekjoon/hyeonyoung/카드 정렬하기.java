import java.io.*;
import java.util.*;

// BOJ_1715

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int answer = 0;
		while(pq.size() >= 2) {
			int x = pq.poll();
			int y = pq.poll();
			
			answer += x + y;
			pq.add(x+y);
		}
		
		System.out.println(answer);
	}
}

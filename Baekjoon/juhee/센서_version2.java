import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] sensor = new int[N];
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensor);
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for (int i = 0; i < N-1; i++) {
			que.offer(sensor[i+1] - sensor[i]);
		}
		
		int total = 0;
		for (int i = 0; i < N - K; i++) {
			total += que.poll();
		}
		System.out.println(total);
	}

}

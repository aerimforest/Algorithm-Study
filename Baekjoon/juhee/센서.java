import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 132ms
// 메모리 : 13844KB
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
		
		int[] dist = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			dist[i] = sensor[i+1] - sensor[i];
		}
		
		Arrays.sort(dist);
		
		int total = 0;
		for (int i = 0; i < N - K; i++) {
			total += dist[i];
		}
		System.out.println(total);
	}

}

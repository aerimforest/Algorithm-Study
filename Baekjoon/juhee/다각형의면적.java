import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 152ms
// 메모리 : 17780KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[][] point = new long[N+1][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
		}
		
		point[N][0] = point[0][0];
		point[N][1] = point[0][1];
		
		long sumX = 0;
		long sumY = 0;
		for (int i = 0; i < N; i++) {
			sumX += point[i][0] * point[i+1][1];
			sumY += point[i][1] * point[i+1][0];
		}
		
		double answer = 1d * Math.abs(sumX - sumY) / 2d;
		System.out.printf("%.1f", answer);
	}

}

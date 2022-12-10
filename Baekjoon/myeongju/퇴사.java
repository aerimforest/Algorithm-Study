import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int result = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0);

		System.out.println(result);
	}

	private static void subset(int cnt, int sum) {

		if (cnt == N) {
			result = Math.max(result, sum);
			return;
		}

		if (arr[cnt][0] + cnt <= N) subset(cnt + arr[cnt][0], sum + arr[cnt][1]);

		subset(cnt + 1, sum);

	}

}

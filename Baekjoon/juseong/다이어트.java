import java.io.*;
import java.util.*;
                
public class Main {

	static int N, A, B, C, D, M = Integer.MAX_VALUE;
	static int[][] data;
	static PriorityQueue<String> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		data = new int[N][5];

		st = new StringTokenizer(br.readLine());
		A = stoi(st.nextToken());
		B = stoi(st.nextToken());
		C = stoi(st.nextToken());
		D = stoi(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				data[i][j] = stoi(st.nextToken());
			}
		}

		backTracking(0, 0, 0, 0, 0, 0, 0);

		if (M == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(M);
			System.out.println(pq.poll());
		}
	}

	private static void backTracking(int D, int a, int b, int c, int d, int allSum, int pick) {
		if (D == N) {
			if (isPossible(a, b, c, d) && allSum <= M) {
				if (allSum < M) {
					pq.clear();
					M = allSum;
				}
				pq.add(convert(pick));
			}
			return;
		}

		// 선택
		backTracking(D + 1, a + data[D][0], b + data[D][1], c + data[D][2], d + data[D][3], allSum + data[D][4],
				pick | (1 << D));
		// 미선택
		backTracking(D + 1, a, b, c, d, allSum, pick);
	}

	private static String convert(int pick) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if ((pick & (1 << i)) != 0) {
				sb.append((i + 1) + " ");
			}
		}
		return sb.toString();
	}

	private static boolean isPossible(int w, int x, int y, int z) {
		return w >= A && x >= B && y >= C && z >= D;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}

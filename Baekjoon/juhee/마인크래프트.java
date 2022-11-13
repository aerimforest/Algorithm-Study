import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 568ms
// 메모리 : 34488KB
public class Main {

	static int B;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		B = Integer.parseInt(st.nextToken()); // 초기 블록
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		int height = 0;
		for (int i = 0; i <= 256; i++) {
			int n = make_map(map, i);
			if(n == -1) continue;
			if(min >= n) {
				min = n;
				height = i;
			}
		}
		System.out.println(min+" "+height);
	}
	private static int make_map(int[][] map, int cnt) {

		int N = map.length;
		int M = map[0].length;
		
		int diff = 0;
		int time = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > cnt) {
					time += (map[i][j] - cnt) * 2;
					diff += (map[i][j] - cnt);
				} else if(map[i][j] < cnt) {
					time += (cnt - map[i][j]);
					diff -= (cnt - map[i][j]);
				}
			}
		}
		if(diff + B >= 0) return time;
		else return -1;
	}

}

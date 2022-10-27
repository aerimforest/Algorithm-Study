import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 360ms
// 메모리 : 43244KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H+X][W+Y];
		int[][] answer = new int[H][W];
		boolean[][] v = new boolean[H][W];
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W+Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 살아남은 윗부분 구하기
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < W; j++) {
				answer[i][j] = map[i][j];
				v[i][j] = true;
			}
		}
		
		// 살아남은 왼쪽 구하기
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < H; j++) {
				answer[j][i] = map[j][i];
				v[j][i] = true;
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(v[i][j]) continue;
				answer[i][j] = map[i][j] - answer[i - X][j - Y];
				v[i][j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int[] is : answer) {
			for (int bs : is) {
				sb.append(bs).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 192ms
// 메모리 : 19548KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = -1;
		// 0 - 5, 1 - 3, 2 - 4
		for (int i = 0; i < 6; i++) {
			int n = find_max(i, dice);
			max = Math.max(max, n);
		}
		System.out.println(max);
	}

	private static int find_max(int n, int[][] dice) {

		int N = dice.length;
		int bottom = n;
		int top = reverse(n);
		int total = 0;
		
		if(dice[0][bottom] + dice[0][top] == 11) total += 4;
		else if(dice[0][bottom] == 6 || dice[0][top] == 6) total += 5;
		else total += 6;
		for (int i = 1; i < N; i++) {
			bottom = find_bottom(dice[i-1][top], dice[i]);
			top = reverse(bottom);
			if(dice[i][bottom] + dice[i][top] == 11) total += 4;
			else if(dice[i][bottom] == 6 || dice[i][top] == 6) total += 5;
			else total += 6;
		}
		return total;
	}

	private static int find_bottom(int top, int[] dice) {

		for (int i = 0; i < 6; i++) {
			if(dice[i] == top) return i;
		}
		return -1;
	}

	private static int reverse(int n) {

		if(n == 0) return 5;
		if(n == 1) return 3;
		if(n == 2) return 4;
		if(n == 3) return 1;
		if(n == 4) return 2;
		return 0;
	}

}

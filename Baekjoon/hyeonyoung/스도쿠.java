import java.io.*;
import java.util.*;

// BOJ_2239

public class Main {
	static boolean finish = false;
	static boolean check(int x, int y, int n, char[][] input) {
		// 가로
		for(int j = 0; j < 9; j++) {
			if(input[x][j] - '0' == n) {
				return false;
			}
		}
		// 세로
		for(int i = 0; i < 9; i++) {
			if(input[i][y] - '0' == n) {
				return false;
			}
		}
		// 네모
		x /= 3;
		y /= 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(input[3*x+i][3*y+j] - '0' == n) {
					return false;
				}
			}
		}
		
		return true;
	}
	static void solve(int idx, char[][] input) {
		if(finish) {
			return;
		}
		if(idx >= 81) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j= 0; j < 9; j++) {
					sb.append(input[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			finish = true;
			return;
		}
		
		int x = idx / 9;
		int y = idx % 9;
		if(input[x][y] != '0') {
			solve(idx+1, input);
		}
		else {
			for(int n = 1; n < 10; n++) {
				if(check(x, y, n, input)) {
					input[x][y] = (char)(n+'0');
					solve(idx+1, input);
					input[x][y] = '0';
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] input = new char[9][9];
		for(int i = 0; i < 9; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		solve(0, input);
	}
}

// 230117_BOJ_1987

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int r, c, answer = 0;
	static int[][] delta = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static boolean[] visit = new boolean[26];
	static void solve(char[][] board, int x, int y, int cnt) {
		answer = Integer.max(answer, cnt);
		for(int k = 0; k < 4; k++){
			int xx = x + delta[k][0];
			int yy = y + delta[k][1];

			if(xx < 0 || xx >= r || yy < 0 || yy >= c){
				continue;
			}

			if(!visit[board[xx][yy] - 'A']){
				visit[board[xx][yy] - 'A'] = true;
				solve(board, xx, yy, cnt+1);
				visit[board[xx][yy] - 'A'] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		char[][] board = new char[r][c];
		for(int i = 0; i < r; i++) {
			board[i] = sc.next().toCharArray();
		}

		visit[board[0][0]-'A'] = true;
		solve(board, 0, 0, 1);

		System.out.println(answer);
	}

}

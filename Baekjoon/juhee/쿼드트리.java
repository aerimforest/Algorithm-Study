package _202209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;

public class BOJ_1992_쿼드트리_실버1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			
		}
		
		System.out.println(quard_tree(map, N, 0, 0));
	}

	private static String quard_tree(char[][] map, int len, int r, int c) {

		char start = map[r][c];
		int N = map.length;
		
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				 if(map[i][j] != start) {
					 StringBuilder sb = new StringBuilder();
					 sb.append('(');
					 sb.append(quard_tree(map, len/2, r, c));
					 sb.append(quard_tree(map, len/2, r, c+len/2));
					 sb.append(quard_tree(map, len/2, r+len/2, c));
					 sb.append(quard_tree(map, len/2, r+len/2, c+len/2));
					 sb.append(')');
					 return sb.toString();
				 }
			}
		}
		return start+"";
	}

}

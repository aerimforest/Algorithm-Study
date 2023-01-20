import java.io.*;
import java.util.*;

// BOJ_1149

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] paint = new int[n][3];
		paint[0][0] = cost[0][0];
		paint[0][1] = cost[0][1];
		paint[0][2] = cost[0][2];
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				paint[i][j] = Integer.min(paint[i-1][(j+1)%3], paint[i-1][(j+2)%3]) + cost[i][j];
			}
		}
		
		int answer = Integer.min(paint[n-1][0], paint[n-1][1]);
		answer = Integer.min(answer, paint[n-1][2]);
		bw.write(Integer.toString(answer));
		
		bw.flush();
		bw.close();
	}

}

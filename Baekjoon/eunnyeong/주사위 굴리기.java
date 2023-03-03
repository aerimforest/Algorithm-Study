import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dice = new int[7]; //주사위 값 저장
	static int up = 1, front = 2, right = 3; //주사위 위치의 index

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n][m]; //좌표 값 저장
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) 
				a[i][j] = Integer.parseInt(st.nextToken());
		}
	
		int[] dx = {0, 0, 0, -1, 1}, dy = {0, 1, -1, 0, 0};//동서북남(1,2,3,4)
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());//명령 순서
		while(st.hasMoreTokens()) {
			int order = Integer.parseInt(st.nextToken()); //명령
			int nx = x + dx[order], ny = y + dy[order]; //좌표 이동
			if (nx >= 0 && nx < n && ny >=0 && ny < m) { //바깥으로 벗어나지 않는 경우
				change(order); //주사위 굴림
				
				//주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
				if (a[nx][ny] == 0) 
					a[nx][ny] = dice[7 - up];
				//0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
				else {
					dice[7 - up] = a[nx][ny];
					a[nx][ny] = 0;
				}
				x = nx; y = ny; //좌표이동
				sb.append(dice[up] + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close(); br.close();
	}
	
	public static void change(int d) { //동서북남 값에 따라서 값을 바꿔줌
		int[] tmp = {-1, -1, -1}; //up, front, right 임시 저장
		
		if (d == 1) {//동
			tmp[0] = 7 - right;
			tmp[2] = up;
		}
		if (d == 2) {//서
			tmp[0] = right;
			tmp[2] = 7 - up;
		}
		if (d == 3) {//북
			tmp[0] = front;
			tmp[1] = 7 - up;
		}
		if (d == 4) {//남
			tmp[0] = 7 - front;
			tmp[1] = up;
		}
		
		if (tmp[0] != -1)
			up = tmp[0];
		if (tmp[1] != -1)
			front = tmp[1];
		if (tmp[2] != -1)
			right = tmp[2];
	}
}

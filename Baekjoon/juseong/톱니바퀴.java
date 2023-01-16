import java.io.*;
import java.util.*;

public class Main {
	static int gear[][];
	static int d[]; //기어의 회전 정보를 담고있음
	static int n,m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		gear = new int[4][8];
		
		for(int i=0; i<4 ;i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = s.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			//배열에 담긴 gear는 1부터 시작이아닌 0부터라 -1을 해줌
			int gearN = Integer.parseInt(st.nextToken()) - 1;
			int turn = Integer.parseInt(st.nextToken());
			
			//톱니의 회전방향 정보를 담음
			d = new int[4]; 
			
			d[gearN] = turn; 
			checkDir(gearN);
			gearTurn();	
		}
		
		int ans =0;
		if(gear[0][0] == 1) ans+=1;
		if(gear[1][0] == 1) ans+=2;
		if(gear[2][0] == 1) ans+=4;
		if(gear[3][0] == 1) ans+=8;
		System.out.println(ans);
	}

	static void checkDir(int gearN){
		//좌측 톱니 회전 방향 검사
		for(int i=gearN-1; i>=0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				d[i] = -d[i+1];
			}else {
				//회전을 하지않으면 다음 톱니도 회전을 하지 않게 된다.  
				break;
			}
		}
		//우측 톱니 회전 방향 검사
		for(int i=gearN+1; i<4; i++) {
			if(gear[i][6] != gear[i-1][2]) {
				d[i] = -d[i-1];
			}else {
				//회전을 하지않으면 다음 톱니도 회전을 하지 않게 된다.  
				break;
			}
		}	
	}
	
	static void gearTurn() {
		int temp = 0;
		
		for(int i=0; i<4; i++) { //모든 톱니에 대해서
			//시계방향 회전
			if(d[i] == 1) {
				temp = gear[i][7];
				for(int j=7; j>0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}
			//반시계방향회전
			if(d[i] == -1) {
				temp = gear[i][0];
				for(int j=0; j<7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
	}
}

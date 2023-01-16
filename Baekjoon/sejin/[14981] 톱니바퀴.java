import java.util.*;
import java.io.*;

// 문제 요약
// 4개의 톱니, 각 길이 8 & 1,0 으로 이루어진 톱니와,1 인 경우 시계 방향 -1 인 경우 반시계방향 회전
// 톱니 회전
	// 톱니 1의 3번째 0 톱니2의 7번째 0 , 톱니 2의 3번째 1, 톱니3의 7번째 1 로 물려있을 때는 회전해도 적용 X
	// 톱이 1이 시계로 회전 시 -> 2:반시계 -> 3:시계 ->  4:반시계 로 회전 
	// 1 : 10101111 , 2 : 01111101 , 3 : 10011101 4:00000001
	// 1 이 시계회전 (맨 뒤가 앞으로), 2 반시계, 3,4 회전 X
	// 1 : 11010111 , 2 : 11111010

// 해결 방법
// 제한 2초에, 4개의 톱니바퀴가 최대 100번 회전이므로 완전탐색 가능
// 단순 구현인 듯.
	// 내가 구현한 방법
		// 현재 톱니의 오른쪽을 확인하고 -> 갈 수 있으면 또 오른쪽을 확인하고 
		// 현재 톱니의 왼쪽을 확인하고 -> 갈 수 있으면 또 왼쪽을 확인하는 형식의 재귀형태로 작성했는데
		// 최대로 갈 수 있었던 바퀴까지 가서 -> 현재 바퀴 상태 변경 하고 멈춰야하는데
		// 돌아오면서도 계속 멈춰서 visited도 넣어봤다가.. 점점 답과 멀어져서 풀이를 봤다
	// 풀이 
		// 회전할 톱니를 한꺼번에 확인한 다음에 -> 한꺼번에 회전
		// 1~4 까지의 톱니 회전 상태를 저장할 배열을 int[4] 생성한다.
		// 현재 톱니를 기준으로 ++ 반복문을 돌려 오른쪽을 확인하고, --반복문을 돌려 왼쪽을 확인한다.
		// 그 다음에, 1~4까지 톱니 회전 상태 배열의 값으로 시계,반시계,회전X 를 구현한다.



public class Main{

	static int K; // 회전 횟수
	static int[][] arr; // 4개의 톱니 정보 N : 0 , S : 1
	static int[] d; // 톱니의 회전 정보

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][8];
		for(int i=0;i<4;i++){
			char[] input = br.readLine().toCharArray();
			for(int j=0;j<8;j++){
				arr[i][j] = input[j] - '0';
			}
		}

		K = Integer.parseInt(br.readLine());
		for(int t=0;t<K;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			d = new int[4];
			d[num] = dir;
			CheckDir(num);
			TurnGear();
		}
		// <-- 
		System.out.println(score());
	}

	public static void CheckDir(int num){
		for(int i=num+1;i<4;i++){ // 오른쪽 톱니 검사
			if(arr[i-1][2] != arr[i][6]){ 
				d[i] = -d[i-1];
			}else break; // 한 번 막히면, 더 이상 갈 수 없다
		}
		for(int i=num-1;i>=0;i--){ // 왼쪽 톱니 검사
			if(arr[i][2]!= arr[i+1][6] ){
				d[i] = -d[i+1];
			}else break; // 한 번 막히면, 더 이상 갈 수 없다
		}
	}

	public static void TurnGear(){
		for(int i=0;i<4;i++){
			if(d[i] == 1 ) ClockWise(i); // 시계방향 회전
			if(d[i] == -1) CounterClockWise(i); // 반시계방향 회전
		}
	}

	public static void ClockWise(int idx){ 
		// 시계방향 회전 : 맨 뒤의 인덱스가 맨 앞으로 오고, 뒤에는 한 칸씩 밀림
		int temp = arr[idx][7]; // 맨 뒤의 인덱스 기억
		for(int i=7;i>0;i--){
			arr[idx][i] = arr[idx][i-1]; // 한 칸씩 밀기
		}
		arr[idx][0] = temp; // 맨 뒤의 인덱스 맨 앞
	}

	public static void CounterClockWise(int idx){
		//반시계방향 회전 : 맨 앞의 인덱스가 맨 뒤로 가고, 뒤에는 앞으로 한 칸씩 당김
		int temp = arr[idx][0];
		for(int i=0;i<7; i++){
			arr[idx][i] = arr[idx][i+1];
		}
		arr[idx][7] = temp;
	}

	public static int score(){
		int count = 0 ;
		// 12시 방향이 S극 일 때 : N극 일 때 점수 계산
		count += (arr[0][0] == 1 ? 1 : 0); 
		count += (arr[1][0] == 1 ? 2 : 0);
		count += (arr[2][0] == 1 ? 4 : 0);
		count += (arr[3][0] == 1 ? 8 : 0);
		return count;
	}

}

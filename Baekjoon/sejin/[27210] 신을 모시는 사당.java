import java.util.*;
import java.io.*;

//문제요약
// 왼쪽 또는 오른쪽을 바라보는 N개의 돌상 
// |(왼쪽보는돌상)-(오른쪽보는돌상)| 왼쪽 - 1 , 오른쪽 - 2
// ex) 1 1 2 1 2

// 해결방법 (시간제한 2초, 1 ≤ N ≤ 100,000 )
// 왼쪽 오른쪽을 비교하면서 간다면 10! 이므로 전체비교
// 값을 입력받을 때, 1 2 가 연속적으로 들어오면 ans + 1
// 문제 이해 잘못함

// 연속된 1 의 개수와 2의 개수 중 더 많은 것
// 단순 구현... left , right ..?
// 연속된 1의 개수.. -> 이전 1의 개수를 기억해야 함 -> 메모이제이션 ! DP ~

// 10시23분 시작


public class Main{

	static int N;
	static int[] arr;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());

		int sum = 0 , max = 0 ;
		// 왼쪽
		for(int i=0;i<N;i++){
			sum += (arr[i]==1? 1:-1);
			if(sum>max) max = sum;
			if(sum<0) sum = 0;
		}

		// 오른쪽
		sum = 0 ;
		for(int i=0;i<N;i++){
			sum += (arr[i]==2? 1:-1);
			if(sum>max) max = sum;
			if(sum<0) sum = 0;
		}

		System.out.println(max);

		
	}
	
}

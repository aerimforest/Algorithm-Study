import java.util.*;
import java.io.*;

// 문제 요약
// 길이가 10,000 이의 자연수로 이루어진 수열
// 연속된 수들의 부분합 중 -> S이상이고, 길이가 가장 짧은 것

// 해결 방법
// 10000 이하의 수열들의 합을 탐색하는데, 0.5초의 시간
// DP일까 이진탐색일까 ...?
// 1. 누적합을 활용한 DP 사용
	// 누적합 O(N) , DP O(N)의 시간복잡도
	// 원하는 구간의 합 계산 시 O(1)의 시간으로 얻을 수 있음
	// 시작점과 끝점을 잡는데 반복문을 2번 돌려야 함 .. -> 이진탐색 사용
// 2. 누적합을 활용한 이진탐색
	// 누적합 O(N), 이진탐색 O(NlogN) 의 시간복잡도
// 합이 불가능한 경우 : 0 출력

public class Main{

	static int N,S; // N짜리 수열, S이상의 합
	static int[] arr; // 입력값
	static int ans = Integer.MAX_VALUE; // 답 , 길이가 가장 짧은 걸 구해야 하므로 최댓값으로 설정

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		// <-- 
		TwoPointer();
		System.out.println(ans != Integer.MAX_VALUE ? ans : 0 );
	}

	public static void TwoPointer(){
		int start = 0 ; // 시작
		int end = 0 ; // 끝
		int sum = 0 ; //누적합

		while(end<=N ){
			
			if (sum >= S ){ // 현재 합이 주어진 S보다 크다면, 시작점 값을 빼주고 start +1 을 한다
				sum -= arr[start++];
				if(ans > (end-start+1)) ans = end - start +1 ; // 현재합이 주어진 S 이상일 때, ans 가 최솟값이 아닐 때
			}else{ // 현재 합이 주어진 S보다 작다면, 끝지점 값을 더해주고 end +1 을 한다
				sum += arr[end++];
			}
		}
	}

}

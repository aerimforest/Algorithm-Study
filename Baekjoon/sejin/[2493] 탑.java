import java.util.*;
import java.io.*;

// 문제요약
// 서로 다른 N개의 탑이 왼쪽으로 레이저를 쏠 때, 제일 먼저 만나는 단 하나의 탑에서만 수신 가능
// 탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지 구하라
// 앞이 자기보다 작을 때는 더 앞으로 가능, 더 크면 return

// 해결방법 ( 시간제한 1.5초, N은 1 이상 500,000 이하 ,  탑들의 높이는 1 이상 100,000,000 이하)
// 이진탐색? 자신의 앞에 값이랑 비교해야하는데.. 이진탐색은 정렬되어 있는 알고리즘에서 특정한 값을 찾는 알고리즘..
// LIFO 스택 자료구조 활용

// 풀이 1시간 소요 

public class Main{

	static int N ; // 탑의 수

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();// 탑들의 높이를 저장할 스택

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx=1;idx<N+1;idx++){ // 자신의 왼쪽값만 비교하므로, 값을 입력받으며 풀이 가능
			int h = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()){
				if(stack.peek()[1] >= h){
					sb.append(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append("0 ");
			stack.push(new int[] {idx,h}); // 현재 인덱스와 높이 삽입
		}
		System.out.println(sb.toString());
	}
}

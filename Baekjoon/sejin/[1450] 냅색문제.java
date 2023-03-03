import java.io.*;
import java.util.*;

// 해결 방법
// 리스트를 A,B 로 반으로 나눔
	// 나올 수 있는 무게의 합의 모든 경우의 수를 리스트에 입력
// 정렬
// 이분탐색

public class Main{

	static int N,C,idx;
	static int[] arr;
	static ArrayList<Integer> aSum, bSum;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // N개의 물건
		C = stoi(st.nextToken()); // 최대 C만큼의 무게 넣을 수 있는 가방
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());
		
		aSum = new ArrayList<>();
		bSum = new ArrayList<>();
		// <--

		FindA(0,0);
		FindB(N/2,0);
		Collections.sort(bSum);

		int ans = 0 ;
		for(int i = 0 ;i < aSum.size(); i++){
			idx = -1 ; 
			binarySearch(0,bSum.size()-1, aSum.get(i));
			ans += idx+1 ;
		}
		System.out.println(ans); 
	}

	// 1,2,3 경우의 수
	static void FindA(int i, int sum){
		if(sum>C) return;
		if(i == N/2){
			aSum.add(sum);
			return;
		}
		FindA(i+1, sum+arr[i]); 
		FindA(i+1,sum);
	}
	// 4,5,6 경우의 수
	static void FindB(int i, int sum){
		if(sum>C) return;
		if(i == N){
			bSum.add(sum);
			return;
		}
		FindB(i+1, sum+arr[i]);
		FindB(i+1, sum);
	}

	public static void binarySearch(int start, int end, int val){
		if(start > end ) return;
		int mid = (start + end) / 2;

		if(bSum.get(mid) + val <= C){
			idx = mid ;
			binarySearch(mid+1, end, val);
		}else{
			binarySearch(start, mid-1, val);
		}
	}
}

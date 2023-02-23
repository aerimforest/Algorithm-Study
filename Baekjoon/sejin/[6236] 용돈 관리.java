import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[] arr ; 
 
	public static void main(String[] args) throws IOException {
		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());

		BinarySearch();
		
		System.out.println(MinResult);
		}

		static int MinResult = Integer.MAX_VALUE;

		// 1. 금액을 정한다음에
		public static void BinarySearch(){
			int start = 1 ;
			int end = 10000 * 100000;

			while(start<=end){
				// System.out.println("start : " + start + " ,end : " + end );

				int mid = (start+end)/2;
				int result = withdrawMoneys(mid);
				if(result>0 && result <= M){
					MinResult = Math.min(MinResult, mid);
					end = mid - 1 ;
				}else{
					start = mid + 1;
				}
			}
		}

		// 해당 금액으로 몇 번의 출금해야하는 지 count 
		public static int withdrawMoneys(int K){
			// System.out.println("withdrawMoneys : " + K );

			int count = 1 ;
			int remainMoney = K ;
			for(int nowMoney : arr){
                if(K < nowMoney) return -1 ;

				if(nowMoney <= remainMoney ){
					remainMoney -= nowMoney ;
				}else{
					remainMoney = K - nowMoney;
					count++;
				}
				// System.out.println("nowMoney : " + nowMoney + " , remainMoney : " + remainMoney + " ,count : " + count);

			}
			return remainMoney<0? -1 : count ;
		}
	}

import java.io.*;
import java.util.*;

// 시간제한 2초 , (1 ≤ N ≤ 200,000, |K| ≤ 2,000,000,000)
// 처음에 2중 반복문을 돌려 sumArr[i] == K + sumArr[i-j] 인 값을 구했으나 시간 초과!
// 맵 자료구조를 사용한당

public class Main{

	static int N,K ;
	static int[] sumArr;
	static long count = 0 ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		sumArr = new int[N+1];
		HashMap<Integer,Long> map = new HashMap<>(); // 누적합의 수와 갯수를 저장할 map

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++){
			sumArr[i] = sumArr[i-1] + stoi(st.nextToken()); // 누적합
			if(sumArr[i] == K ) count ++ ; // 현재합이 K 인 경우 +1

			if(map.containsKey(sumArr[i]-K)) count += map.get(sumArr[i]-K);
			if(!map.containsKey(sumArr[i])) map.put(sumArr[i],1L);
			else map.put(sumArr[i], map.get(sumArr[i])+1);
		}

		System.out.println(count);

	}

}

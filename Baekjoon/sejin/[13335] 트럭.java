import java.io.*;
import java.util.*;

class truck{
	int myWeight, NowBridge;
	truck(int myWeight, int NowBridge){
		this.myWeight = myWeight;
		this.NowBridge = NowBridge;
	}
}
 
public class Main {

	static int trucksCount, BridgeLength, BridgeMaxWeight ;
	static int[] arr ;
 
	public static void main(String[] args) throws IOException {
		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		trucksCount = Integer.parseInt(st.nextToken());
		BridgeLength = Integer.parseInt(st.nextToken());
		BridgeMaxWeight = Integer.parseInt(st.nextToken());
		arr = new int[trucksCount];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<trucksCount;i++) arr[i] = Integer.parseInt(st.nextToken());
		// <--

		int nowWeight = 0 ; // 무게
		Queue<truck> q = new LinkedList<>();
		q.add(new truck(arr[0], 1)); // 첫번째 트럭 출발
		nowWeight += arr[0];
		int nowIdx = 1 ;
		int Time = 1 ;

		while(!q.isEmpty()){
			Time ++ ;

			// System.out.println("시간 : " + Time);
			// 1. q에 있는 NowBridge 가 BridgeLength 라면 빼고, 아니면 +1
			truck firstT = q.peek();
			if(firstT.NowBridge == BridgeLength){
				nowWeight -= firstT.myWeight;
				q.poll();
			}

			for(truck nowT : q) nowT.NowBridge ++ ;

			// 2. 현재 다리 위의 무게가 BridgeMaxWeight 보다 낮고, 다음 트럭을 더한 값과 크거나 같다면 q에 삽입
			if(nowIdx < trucksCount &&( nowWeight + arr[nowIdx]) <= BridgeMaxWeight){
				q.add(new truck(arr[nowIdx], 1));
				nowWeight += arr[nowIdx];
				nowIdx ++ ;
			}

			// for(truck nowT : q ){
			// 	System.out.println(nowT.myWeight + " , " + nowT.NowBridge);
			// }

			// System.out.println();

		}
		System.out.println(Time);
	}
}

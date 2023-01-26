import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//문제요약
// 3*3  배열 
// R 연산 : 배열 A의 모든 행 정렬 ( 행 >= 열 인 경우)
// C 연산 : 배열 A의 모든 열 정렬 ( 핼 < 열 인 경우)
// 행 또는 열 크기가 100을 넘어가는 경우에는, 처음 100개를 제외한 나머지는 버림
// 100번 연산 후에도 X -> -1 

// 해결방법 (시간제한 0.5초, 1 ≤ r,c,k ≤ 100 )
// 정렬 + 구현

class Node implements Comparable<Node>{
	int num, count;
	public Node(int num, int count){
		this.num = num;
		this.count = count;
	}

	// count 작은 거 , 숫자 작은 거 순으로
	@Override
	public int compareTo(Node o){
		if (this.count == o.count) return this.num - o.num;
		return this.count - o.count ;
	}
}

public class Main{

	static int R,C,K; // arr[R][C] = K 가 될 때의 최소 연산
	static int[][] arr; // 초기 3*3 의 맵
	static int nowR = 3 , nowC = 3 ; // 행과 열의 현재 길이

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken())-1;
		C = stoi(st.nextToken())-1;
		K = stoi(st.nextToken());
		arr = new int[101][101];

		for(int i=0;i<3;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) arr[i][j] = stoi(st.nextToken());
		}
		// <--

		System.out.println(solution());
	}

	public static int solution(){
		int time = 0 ; // 정답

		while(time <= 100){ // 100초 까지만 진행
			if(arr[R][C] == K) return time;

			if(nowR >= nowC) Rsort(); // 행>=열 일 때 , R연산
			else Csort(); // 행 < 열 일 때, C연산

			time ++ ;
		}
		return -1 ;
	}

	public static void Rsort(){
		int[][] sortArr = new int[101][101];
		int col = 0 ;

		for(int i=0;i<nowR;i++){
			HashMap<Integer, Integer> hm = new HashMap<>();
			// 해당 행의 숫자들을 해시맵에 저장 , 중복될 경우 +1
			for(int j=0;j<nowC;j++){
				if(arr[i][j]==0) continue;
				if(hm.containsKey(arr[i][j])){
					hm.put(arr[i][j],hm.get(arr[i][j])+1);
				}else hm.put(arr[i][j], 1);
			}
			// 저장된 행들을 정렬
			ArrayList<Node> list = new ArrayList<>();
			for(Map.Entry<Integer, Integer> entry:hm.entrySet()){
				list.add(new Node(entry.getKey(),entry.getValue()));
			}

			col = Math.max(col, list.size()*2);
			Collections.sort(list);
			for(int p=0;p<list.size();p++){
				if(p>=50)break;
				Node node = list.get(p);
				sortArr[i][2*p] = node.num;
				sortArr[i][2*p+1] = node.count;
			}
		}
		nowC = Math.min(99, col);
		arr = sortArr;
	}

	public static void Csort(){
		int[][] sortArr = new int[101][101];
		int row = 0 ;
		for(int j=0;j<nowC;j++){
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int i=0;i<nowR;i++){
				if(arr[i][j] == 0 ) continue;
				if(hm.containsKey(arr[i][j])){
					hm.put(arr[i][j], hm.get(arr[i][j])+1);
				}else hm.put(arr[i][j] , 1);

				ArrayList<Node> list = new ArrayList<>();
				for(Map.Entry<Integer, Integer> entry:hm.entrySet()){
					list.add(new Node(entry.getKey(),entry.getValue()));
				}
				row = Math.max(row, list.size()*2);
				Collections.sort(list);
				for(int p=0;p<list.size();p++){
					if(p>=50)break;
					Node node = list.get(p);
					sortArr[2*p][j] = node.num;
					sortArr[2*p+1][j] = node.count;
				}
			}
		}
		nowR = Math.min(99,row);
		arr = sortArr;
	}
}

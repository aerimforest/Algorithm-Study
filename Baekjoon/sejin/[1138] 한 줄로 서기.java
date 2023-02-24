import java.io.*;
import java.util.*;


public class Main {

	static int N; 
	static int[] arr;
	static ArrayList<Integer> result;
	static boolean[] visited ;

	public static void main(String[] args) throws IOException {
		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new ArrayList<>();
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean ck = false;
		for(int i=0;i<N;i++){
			arr[i] =  Integer.parseInt(st.nextToken());
			if(arr[i]==0 && !ck){ // 제일 낮은 0을 넣어줌
				result.add(i); // 줄의 첫번째 사람번호
				visited[i] = true ; // 방문처리
				ck = true ; // 더 높은 0이 들어오지 못하게
				lastNum = 0 ;
			}
		}
		MakeLine(0);

	} 

	static int lastNum = 0 ; // 줄의 맨 마지막 사람의 왼쪽

	public static void MakeLine(int startIdx){
		// System.out.println(result.toString());

		if(result.size() == N ){
			// print result
			StringBuilder sb = new StringBuilder();
			for(int num : result)sb.append((num+1) + " ");
			System.out.println(sb.toString());
			System.exit(0);
		}

		for(int i=0;i<N;i++){
			// System.out.println("result check  " + i +" : "+ check(i));
			if(!visited[i] && check(i)){ // 줄을 아직 못 선 숫자인 경우
				visited[i] = true ;
				result.add(i);
				MakeLine(0);
				result.remove(result.size()-1);
				visited[i] = false ;
			}
		}
	}

	public static boolean check(int nowNum){
		int checkCount = 0 ;
		for(int bef : result){
			if(bef > nowNum) checkCount ++ ;
		}

		// System.out.println(checkCount);
		if(checkCount == arr[nowNum]) return true ;
		else return false ;
	}

}


import java.io.*;
import java.util.*;


public class Main{

	static int N,M;
	static ArrayList<String> result;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		result = new ArrayList<>();

		HashMap<String, Integer> hm = new HashMap<>();
		// 듣도 못한 사람 넣기
		for(int i=0;i<N;i++){
			hm.put(br.readLine(), 1);
		}

		// 보도 못한 사람이 듣도 못한 사람 명단에 있을 경우, result에 추가
		for(int i=0;i<M;i++){
			String now = br.readLine();
			if(hm.containsKey(now)){
				result.add(now);
			}
		}

		Collections.sort(result); // 사전순 정렬

		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append('\n');
		for(String name : result){
			sb.append(name).append('\n');;
		}
		System.out.print(sb);

	}
}

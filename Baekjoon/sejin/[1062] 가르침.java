import java.util.*;
import java.io.*;

public class Main{

	static int N,K; //N개의 단어, K개의 알파벳
	static String[] arr; // 단어들 저장
	static boolean[] visited; // 알파벳 방문 확인

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String args[]) throws Exception{
        // 값 입력받기 --> 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		K = stoi(st.nextToken());

		if(K<5) { // a,n,t,i,c 를 읽을 수 없으면 아무 단어도 읽을 수 없으므로 탈락
			System.out.println(0);
			return;
		}else if(K == 26){
			System.out.println(N);
			return;
		}

		arr = new String[N];
		visited = new boolean[26];

		for(int i=0;i<N;i++){
			String str = br.readLine();
			arr[i] = str.substring(4,str.length()-4); //anta, tica 빼고 받기			
		}
		//<--

		// a,n,t,i,c 는 읽을 수 있는 단어로 표시 
		K = K-5;
		char[] okChar = {'a','n','t','i','c'};
		c(okChar);

		Find(0,0);
		System.out.println(ans);

	}

	public static void c(char[] arr){
		for(char str : arr){
			int idx = str-'a';
			visited[idx] = true;
		}
	}

	public static int ans = Integer.MIN_VALUE;

	public static void Find(int alpha, int count){
		if(K == count){ // K개 만큼 알파벳을 모았을 때 리턴
			int chk = 0;

			for(int i=0;i<N;i++){
				boolean isSame = true;
				for(int j=0;j<arr[i].length();j++){
					if(!visited[arr[i].charAt(j)-'a']){
						isSame = false;
						break;
					}
				}
				if(isSame) chk ++ ;
			}
			ans = Math.max(ans, chk);
			return;
		}

		for(int i=alpha;i<26;i++){
			if(visited[i] == false){
				visited[i] = true;
				Find(i, count+1);
				visited[i] = false;
			}
		}
	}
	
}

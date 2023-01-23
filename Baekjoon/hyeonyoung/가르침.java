import java.io.*;
import java.util.*;

// BOJ_1062

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		
		// anta / tica
		int fix = 0;
		fix |= (1<<('a'-'a'));
		fix |= (1<<('c'-'a'));
		fix |= (1<<('i'-'a'));
		fix |= (1<<('n'-'a'));
		fix |= (1<<('t'-'a'));
		
		// n, k 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 단어 n개 입력
		int[] words = new int[n];
		for(int i = 0; i < n; i++) {
			String word = br.readLine();
			
			words[i] = fix;
			for(int j = word.length()-5; j >= 4; j--) {
				words[i] |= (1<<(word.charAt(j)-'a'));
			}
		}
		
		// k개 교육 ?
		for(int edu = 0; edu < (1<<26); edu++) {
			// prefix, postfix 는 고정
			if((edu&fix) != fix) {
				continue;
			}
			
			int count = 0;
			for(int i = 0; i < 26; i++) {
				if((edu & (1<<i)) != 0) {
					count++;
				}
			}
			
			if(count != k) {
				continue;
			}
			
			// 읽을 수 있는 단어
			count = 0;
			for(int i = 0; i < n; i++) {
				if((edu & words[i]) == words[i]) {
					count++;
				}
			}
			
			answer = Integer.max(answer, count);
		}
		
		sb.append(answer);
		System.out.println(sb);
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11560KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
			System.out.println(0);
			return;
		}
		
		int[] order = new int[K+1];
		boolean[] tab = new boolean[K+1];
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= K; i++) {
			if(tab[order[i]]) continue;
			cnt++;
			tab[order[i]] = true;
			if(cnt == N) break;
		}
		
		int total = 0;
		for (int i = 1; i <= K; i++) {
			if(tab[order[i]]) continue; // 이미 꽂혀 있으면 넘어감
			// 아니라면 앞으로 있어야 하는 것 중 가장 나중에 나올 애 빼
			int[] v = new int[K+1];
			for (int j = i+1; j <= K; j++) {
				if(tab[order[j]] && v[order[j]] == 0) {
					v[order[j]] = j - i;
				}
			}
			int swap = 0;
			int loc = 0;
			for (int j = 1; j <= K; j++) {
				if(tab[order[j]]) {
					if(v[order[j]] == 0) {
						swap = j;
						break;
					} else if(v[order[j]] > 0) {
						if(loc < v[order[j]]) {
							loc = v[order[j]];
							swap = j;
						}
					}
				}
			}
			
			tab[order[swap]] = false;
			tab[order[i]] = true;
			total++;
		}
		System.out.println(total);
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, L, answer;
	static int[] min, plu;
	static boolean[] solved;
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		answer = 0;
		Arrays.sort(min);
		Arrays.sort(plu);
		
		for(int i=0; i<N; i++) {
			if(solved[i])
				continue;
			solved[i] = true;
			answer++;
			
			for(int j=i+1; j<N; j++) {
				if(plu[j] <= min[i] + L) {
					solved[j] = true;
				}
				else {
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		min = new int[N];
		plu = new int[N];
		solved = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			min[i] = Integer.parseInt(st.nextToken());
			plu[i] = min[i] + 1;
		}
		
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클_게임 {
	
	static int N, M;
	static int[] set;
	
	public static void main(String[] args) throws IOException {
		input();
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new int[N];
		for(int i=1; i<N; i++) 
			set[i] = i;
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = find(Integer.parseInt(st.nextToken()));
			int b = find(Integer.parseInt(st.nextToken()));
			
			if(a==b) {
				System.out.println(i);
				return;
			}
			
			if(a>=b) 
				set[b] = a;
			else
				set[a] = b;
		}
		System.out.println(0);
		br.close();
	}
	private static int find(int x) {
		if(set[x]==x)
			return x;
		return set[x] = find(set[x]);
	}
}

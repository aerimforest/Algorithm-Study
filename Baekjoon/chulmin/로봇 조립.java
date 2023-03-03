import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18116 {
	
	static int[] arr;	
	static int[] cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		init();
		input();
		pro();
	}

	private static void pro() {
		System.out.println(sb);
	}

	private static void init() {
		arr = new int[1000001];
		cnt = new int[1000001];
		
		sb = new StringBuilder();
		
		for(int i=0; i<1000001; i++) {
			arr[i] = i;
			cnt[i] = 1;
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N =Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			
			switch(cmd) {
			case 'I':
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int px = find(a);
				int py = find(b);
				
				if(px != py) {
					arr[py] = px;
					cnt[px] += cnt[py];
				}
				break;
			
			case 'Q':
				int c = Integer.parseInt(st.nextToken());
				sb.append(cnt[find(c)] + "\n");
				break;
			}
		}
		br.close();
	}

	private static int find(int x) {
		if(x == arr[x]) return arr[x];
		return arr[x] = find(arr[x]);
	}
}

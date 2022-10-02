import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Subin{
		int cnt;
		int last;
		String prev;
        
		public Subin(int cnt, int state) {
			super();
			this.cnt = cnt;
			last = state;
			prev = new String();
			prev += state;
		}
		
		public Subin(int cnt, int last, String list) {
			super();
			this.cnt = cnt;
			this.last = last;
			this.prev = list+" "+last;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Subin> que = new LinkedList<>();
		que.offer(new Subin(0, N));
		
		boolean[] v = new boolean[100001];
		v[N] = true;
		
		if(N>=K) {
			System.out.println(N-K);
			StringBuilder sb = new StringBuilder();
			for (int i = N; i >=K; i--) {
				sb.append(i+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		while(!que.isEmpty()) {
			Subin cur = que.poll();
			int state = cur.last, cnt = cur.cnt;
			if(cur.last == K) {
				System.out.println(cnt);
				System.out.println(cur.prev);
				break;
			}
			if(state<K) {
				if(state*2<=100000 && !v[state*2]) {
					v[state*2] = true;
					que.offer(new Subin(cur.cnt+1, state*2, cur.prev));
				}
				if(state+1<=100000 && !v[state+1]) {
					v[state+1] = true;
					que.offer(new Subin(cnt+1, state+1, cur.prev));
				}
			}
			if(state-1>=0 && !v[state-1]) {
				que.offer(new Subin(cnt+1, state-1, cur.prev));
				v[state-1] = true;
			}
		}
		
	}

}

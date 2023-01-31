import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] mat;
	static HashMap<Integer, Long> hm;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mat = new int[N+1];
		hm = new HashMap<Integer, Long>();
		
		long answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			mat[i] = Integer.parseInt(st.nextToken()) + mat[i-1];
			if(mat[i]==K)
				answer++;
			// mat[i] - 이전에 나온 합 = K 이면 갯수 더해준다.
			if(hm.containsKey(mat[i] - K))
				answer += hm.get(mat[i] - K);
			hm.put(mat[i], hm.getOrDefault(mat[i], 0L) + 1);
		}
		System.out.println(answer);
		br.close();
	}
}

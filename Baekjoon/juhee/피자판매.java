import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 548ms
// 메모리 : 126628KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] tmp = new int[A];
		List<Integer> a = new ArrayList<>();
		Map<Integer, Integer> b_map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < A; i++) {
			tmp[i] = Integer.parseInt(br.readLine());
			sum+= tmp[i];
		}
		
		if(sum <= N) a.add(sum);
		for (int i = 0; i < A; i++) {
			int t = 0;
			for (int j = i; j < i+A-1; j++) {
				if(j >= A) t += tmp[j - A];
				else t += tmp[j];
				if(t > N) break;
				else a.add(t);
			}
		}
		
		tmp = new int[B];
		sum = 0;
		for (int i = 0; i < B; i++) {
			tmp[i] = Integer.parseInt(br.readLine());
			sum += tmp[i];
		}
		if(sum <= N) b_map.put(sum, 1);
		for (int i = 0; i < B; i++) {
			int t = 0;
			for (int j = i; j < i+B-1; j++) {
				if(j >= B) t += tmp[j - B];
				else t += tmp[j];
				if(t > N) break;
				else {
					if(b_map.containsKey(t)) {
						b_map.put(t, b_map.get(t) + 1);
					} else {
						b_map.put(t, 1);
					}
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i) == N) {
				total++;
				continue;
			}
			if(b_map.containsKey(N-a.get(i))) {
				total += b_map.get(N-a.get(i));
			}
		}
		if(b_map.containsKey(N)) {
			total += b_map.get(N);
		}
		
		System.out.println(total);
	}

	

}

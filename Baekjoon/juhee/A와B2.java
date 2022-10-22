import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 시간 : 76ms
// 메모리 : 11584KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String end = br.readLine();
		
		Queue<String> que = new LinkedList<>();
		que.offer(end);
		
		while(!que.isEmpty()) {
			String cur = que.poll();
			if(cur.equals(start)) {
				System.out.println(1);
				return;
			}
			if(cur.length() <= start.length()) continue;
			
			StringBuilder sb = new StringBuilder();
			if(cur.charAt(cur.length()-1) == 'A') {
				que.offer(cur.substring(0, cur.length()-1));
				if(cur.charAt(0) == 'B') {					
					for (int i = cur.length()-1; i > 0; i--) {
						sb.append(cur.charAt(i));
					}
					que.offer(sb.toString());
				}
			} else {
				if(cur.charAt(0) == 'B') {					
					for (int i = cur.length()-1; i > 0; i--) {
						sb.append(cur.charAt(i));
					}
					que.offer(sb.toString());
				}
			}
		}
		System.out.println(0);
	}

}

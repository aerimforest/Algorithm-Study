import java.io.*;
import java.util.*;

// BOJ_1764

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		Set<String> listen = new HashSet<>();
		for(int i = 0; i < n; i++) {
			listen.add(br.readLine());
		}
		
		ArrayList<String> answer = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			String watch = br.readLine();
			if(listen.contains(watch)) {
				answer.add(watch);
			}
		}
		
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size());
		sb.append("\n");
		for(String a : answer) {
			sb.append(a);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 80ms
// 메모리 : 11632KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = 2;
		
		StringBuilder sb = new StringBuilder();
		while(start < end) {
			int tmp = end*end - start*start; 
			if(tmp == N) {
				sb.append(end).append("\n");
				end++;
			} else if(tmp < N) {
				end++;
			} else {
				start++;
			}
		}
		if(sb.length() == 0) System.out.println(-1);
		else System.out.println(sb);
	}

}

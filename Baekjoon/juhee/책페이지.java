import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 80ms
// 메모리 : 11540KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] num = new int[10];
		int len = str.length();

		for (int i = 0; i < len; i++) {
			int n = str.charAt(i) - '0';
			int prev = 1;
			int post = 1;
			if(i != 0) prev = Integer.parseInt(str.substring(0, i))+1;
			if(i != len - 1) post = Integer.parseInt(str.substring(i+1))+1;
			for (int j = 0; j < 10; j++) {
				int tmp = prev;
				if(j == 0) tmp = prev - 1;
				if(j < n) num[j] += tmp * Math.pow(10, len-i-1);
				else if(j == n) num[j] += (tmp - 1) * Math.pow(10, len-i-1) + post;
				else num[j] += (tmp-1)*Math.pow(10, len-i-1);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i : num) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
		
	}

}

import java.io.*;
import java.util.*;

// BOJ_10422
// 카탈란 수

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int DIV = 1000000007;
		
		long[] catalan = new long[5001];
		catalan[0] = 1;
		for(int i = 1; i <= 2500; i++) {
			for(int j = 0; j < i; j++) {
				catalan[i] = (catalan[i] + catalan[j]*catalan[i-j-1]) % DIV;
			}
		}
		
		
		int t = Integer.parseInt(br.readLine());
		for(int tt = 0; tt < t; tt++) {
			int n = Integer.parseInt(br.readLine());
			
			if((n&1) == 0) {
				bw.write(Long.toString(catalan[n/2]));
				bw.newLine();
			}
			else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}

import java.io.*;
import java.util.*;

// BOJ_27210

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 0, max = 0, sum = 0;
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == 1) {
				sum++;
			}
			else {
				sum--;
			}
			
			min = Integer.min(min, sum);
			max = Integer.max(max, sum);
		}
		
		System.out.println(max-min);
	}
}

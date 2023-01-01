import java.util.*;
import java.io.*;

public class Main {
	
	static int ans, n;
	static int[] l, j;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		l = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			l[i] = Integer.parseInt(st.nextToken());
		
		j = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			j[i] = Integer.parseInt(st.nextToken());
		
		select = new boolean[n];
		ans = -1;
		subset(0);
		System.out.println(ans);
	}
	
	public static void subset(int cnt) {
		if (cnt == n) {
			int s1 = 0, s2 = 0; //체력, 기쁨
			for (int i = 0; i < n; i++) {
				if (select[i]) {
					s1 += l[i];
					s2 += j[i];
					if (s1 >= 100) return;
				}
			}
			if (s1 < 100 && s2 > ans)
				ans = s2;
			return;
		}
		
		select[cnt] = true;
		subset(cnt + 1);
		select[cnt] = false;
		subset(cnt + 1);
	}
}
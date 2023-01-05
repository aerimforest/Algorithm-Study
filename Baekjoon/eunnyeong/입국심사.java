import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, max;
	static int[] a;
	static long ans;
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());

	    a = new int[n];
	    max = 0;
	    for (int i = 0; i < n; i++) {
	        a[i] = Integer.parseInt(br.readLine());
	        max = Math.max(a[i] , max);
	    }
	    
	    check();
	    
	    System.out.println(ans); 
	}
	
	public static void check() {
		long left = 1, right = max * m;
		ans = 0;
		while (left <= right) {
			long mid = left + (right - left) / 2, sum = 0;
			
			for (int i = 0; i < n; i++)
				sum += mid / a[i];
			
			if (sum < m)
				left = mid + 1;
			else {
				ans = mid;
				right = mid - 1;
			}
		}
		return;
	}
}

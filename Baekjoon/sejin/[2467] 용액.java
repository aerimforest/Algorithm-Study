import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int left =0;
		int right =n-1;
		int ml =0, mr = 0;
		long min = Long.MAX_VALUE;
		while(left<right) {
			long sum = arr[left]+arr[right];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				ml = left; mr = right;
			}
			if(sum>=0) {
				right--;	
			}else {
				left++;
			}
		}
		System.out.println(arr[ml] +" "+arr[mr]);
	}
}

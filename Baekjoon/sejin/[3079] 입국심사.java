import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] timeArr ;
	static int timer = 0 , people = 0 ;
	static int MaxTime = 0 ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		timeArr = new int[N];
		for(int i=0;i<N;i++){
			timeArr[i] = Integer.parseInt(br.readLine());
			MaxTime = Math.max(MaxTime, timeArr[i]);
		}

		Arrays.sort(timeArr);

		long start = 1;
		long end = (long) MaxTime * M ;
		long ans = 0 ;

		while (start <= end){
			long mid = (start+end)/2;
			long sum = 0;
			for(int i=0;i<N;i++){
				sum += (mid/timeArr[i]);
				if (sum >=M ) break;
			} 
			if(sum >=M) end = mid - 1;
			else start = mid + 1;
		}
		System.out.println(start);
	}
}

import java.io.*;
import java.util.*;

// BOJ_2015

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int[] arr = new int[n+1];
		line = br.readLine().split(" ");
		long answer = 0;
		for(int i = 1; i <= n; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(line[i-1]);
		}
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 1; i <= n; i++) {
			if(arr[i] == k) {
				answer++;
			}
			
			if(map.containsKey(arr[i]-k)) {
				answer += map.get(arr[i]-k);
			}
			
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);				
			}
		}
		System.out.println(answer);
	}
}

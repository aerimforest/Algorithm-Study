import java.io.*;
import java.util.*;

// BOJ_1450

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		
		int[] weights = new int[n];
		input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(input[i]);
		}

		// 0 ~ 14
		List<Integer> list1 = new ArrayList<>();
		list1.add(0);
		for(int i = 0; i < n && i < 15; i++) {
			for(int j = list1.size()-1; j >= 0; j--) {
				if(list1.get(j) + weights[i] <= c) {
					list1.add(list1.get(j) + weights[i]);
				}
			}
		}
		Collections.sort(list1);
		
		// 15 ~ 29
		List<Integer> list2 = new ArrayList<>();
		list2.add(0);
		for(int i = 15; i < n; i++) {
			for(int j = list2.size()-1; j >= 0; j--) {
				if(list2.get(j) + weights[i] <= c) {
					list2.add(list2.get(j) + weights[i]);
				}
			}
		}
		Collections.sort(list2);

		int answer = 0;
		int y = list2.size()-1;
		for(int x = 0; x < list1.size(); x++) {
			while(y >= 0 && list1.get(x) + list2.get(y) > c) {
				y--;
			}
			
			if(y < 0) {
				break;
			}
			answer += y+1;
		}
		System.out.println(answer);
	}
}

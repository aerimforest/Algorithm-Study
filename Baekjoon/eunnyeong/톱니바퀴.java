import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] a;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList list[] = new LinkedList[5];
		
		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();
			LinkedList<Integer> t = new LinkedList<>();
			for (int j = 0; j < 8; j++)
				t.add(s.charAt(j) - '0');
			list[i] = t;
		}
		
		for (int i = 0; i < 8; i++) 
			System.out.println(list[1].get(i));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int[] check = new int[5]; //톱니바퀴 체크
			check[x] = y;
			
			int c = y;
			for (int j = x + 1; j <= 4; j++) { //오른쪽 체크
				if (list[j].get(0) != list[j - 1].get(4)) {
					c *= -1;
					check[j] = c;
				}
				else break;
			}
			
			c = y;
			for (int j = x - 1; j >= 1; j--) { //오른쪽 체크
				if (list[j].get(4) != list[j + 1].get(0)) {
					c *= -1;
					check[j] = c;
				}
				else break;
			}
			
			for (int j = 1; j <= 4; j++) {
				if (check[j] == 1)
					list[j].addFirst(list[j].pollLast());
				if (check[j] == -1)
					list[j].addLast(list[j].pollFirst());
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 4; i++) {
			if (list[i].indexOf(list[i].get(2)) == 1)
				sum += 1 * i;
		}
		
		System.out.println(sum);	
	}

}

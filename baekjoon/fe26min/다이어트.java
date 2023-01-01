package ThisWeek21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 다이어트 {
	static int G;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		arr = new ArrayList<Integer>();
		// 현재 무게 A
		// 이전 무게 B
		// A^2 - B^2 = G
		// (A+B) * (A-B) = G
		// G의 약수들로 쌍을 이루는 것 들을 찾는다.
		
		// 1부터 G의 제곱근까지 탐색
		// <= 으로 하면 틀리다.
		// A+B와 A-B가 같아지면 B가  0이 된다.
		for(int i=1; i<Math.sqrt(G); i++) {
			// G의 약수 인가? 
			if(G % i != 0) continue;
			
			// i = A-B 즉 AmB이고
			// i로 나눈 몫이 A+B이다.
			int ApB = G / i;
			
			// ApB + AmB = 2 * A;이다.
			// ApB + AmB가 홀수이면 A는 자연수가 아니다.
			if((ApB + i) % 2 == 1) continue;
			
			// ApB - AmB = 2 * B;이다.
			// ApB - AmB가 홀수이면 B는 자연수가 아니다.
			if((ApB - i) % 2 == 1) continue;
			
			arr.add((ApB + i) / 2);
		}
		if(arr.size()==0) {
			System.out.println(-1);
			return;
		}
		
		for(int i=arr.size()-1; i>=0; i--) {
			System.out.println(arr.get(i));
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		br.close();
	}
}

package Baekjoon.seongkil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import Baekjoon.seongkil.Sample.Cup;
import Baekjoon.seongkil.Sample.FastReader;

public class B1781_컵라면 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static ArrayList<Cup> arr;

	static void input() {
    	N = scan.nextInt();
    
    	arr = new ArrayList<>();
    	
    	for (int i = 1; i <= N; i++) {
    		int dead = scan.nextInt();
    		int count = scan.nextInt();
    		arr.add(new Cup(dead, count));
    	}
    	
    	Collections.sort(arr);
    }

	static void pro() {	 	    	
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int dead = arr.get(i).dead;
			int count = arr.get(i).count;
			pq.add(count);
			if (dead < pq.size()) {
				pq.poll();
			}
		}
		long result = 0;

		while (!pq.isEmpty()) {
			result += pq.poll();
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		input();
		pro();

	}

	static class Cup implements Comparable<Cup> {
		public int dead, count;

		public Cup(int _dead, int _count) {
			this.dead = _dead;
			this.count = _count;
		}
		
		public int compareTo(Cup o) {
			if(dead == o.dead)
			{
				return o.count-count; 
			}
			else {
				return dead - o.dead;
			}
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
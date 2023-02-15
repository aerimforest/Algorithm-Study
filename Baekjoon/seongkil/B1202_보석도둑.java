package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import Baekjoon.seongkil.Sample.FastReader;
import Baekjoon.seongkil.Sample.Jewelry;

public class B1202_보석도둑 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, K;
    static int[] bags;
    
    static Jewelry[] jewelries;
    
    static void input() {
    	N = scan.nextInt();
    	K = scan.nextInt();
    	
    	jewelries = new Jewelry[N];
    	
    	for (int i = 0; i < N; i++) {          
             int m = scan.nextInt();
             int v = scan.nextInt();
  
             jewelries[i] = new Jewelry(m, v);
        }
    	
    	Arrays.sort(jewelries, new Comparator<Jewelry>() {
 
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.mass == o2.mass) {
                    return o2.cost - o1.cost;
                }
                return o1.mass - o2.mass;
            }
 
        });
    	
    	bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = scan.nextInt();
        }
    	
    	Arrays.sort(bags);
    }
    
    private static void pro() {
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            
            while (j < N && jewelries[j].mass <= bags[i]) {
                pq.offer(jewelries[j++].cost);
            }
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
		
	}
    
    public static void main(String[] args) {
    	input();
    	pro();
    }
    

	static class Jewelry {
        int mass, cost;  
     
        Jewelry(int mass, int cost) {
            this.mass = mass;
            this.cost = cost;
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
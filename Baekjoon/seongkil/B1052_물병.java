package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1052_물병 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, K;
    static String binaryN;
    
    static void input() {
    	N = scan.nextInt();
    	K = scan.nextInt();
    	binaryN = Integer.toBinaryString(N);
    }
    
    static void pro() {
    	int ones = 0;
		for(int i=0; i<binaryN.length(); i++) {
			if(binaryN.charAt(i) == '1') {
				ones++;
			}
		}
		int cnt = 0;
		int point = 0;
		if(ones <= K) {
			System.out.println(0);
		}else {
			for(int i=0; i<binaryN.length(); i++) {
				if(binaryN.charAt(i) == '1') {
					cnt++;
					if(cnt == K) {
						point = i;
						break;
					}
				}
			}
			String stringAnswer = binaryN.substring(point);
			int answer = Integer.parseInt(stringAnswer, 2);
			int temp = 0;
			for (int i = 0; i < binaryN.length()-point; i++) {
				temp = temp << 1;
				temp = temp+1;
			}
			answer ^= temp;
			answer = answer+1;
			System.out.println(answer);
		}
    }
    
    public static void main(String[] args) {
    	input();
    	pro();
    	    	
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
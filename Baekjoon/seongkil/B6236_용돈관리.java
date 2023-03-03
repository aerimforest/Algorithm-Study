package Baekjoon.seongkil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6236_용돈관리 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M;
    static int[] pays;
	static int maxHigh;
	static int sum;
	
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	
    	pays = new int[N+1];
    	
    	for (int i = 0; i < N; i++) {
    		pays[i] = scan.nextInt();
    		maxHigh = Math.max(maxHigh,  pays[i]);
    		sum += pays[i];
    	}
    }
    
    static int possiblePay(int withdraw, int n, int m) {
		int nowMoney = 0;
		int nowCount = 0;
		
		for(int i = 0; i < n; i++) {
			if(withdraw < pays[i]) {	
				return -1;
			}
			
			if(nowMoney < pays[i]) {
				nowCount++;
				nowMoney = withdraw;
				if(nowCount > m) {
					return 0;
				}
			}
			
			nowMoney -= pays[i];
		}
		
		return nowCount == m ? 1 : 2;
	}
    
    private static void pro() {
		int low = maxHigh;
		int high = sum;
		
		do {
			int mid = (low + high) / 2;
			int cnt = 1;
			int money = mid;
			
			for (int i = 0; i < N; i++) {
				if (pays[i] > money) {
					money = mid;
					cnt++;
				}
				money = money - pays[i];
			}

			if (cnt > M)
				low = mid + 1;
			else
				high = mid - 1;
		} while (low <= high);
		
		System.out.println(low);
		
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
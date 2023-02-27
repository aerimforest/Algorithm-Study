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

public class B22862_가장긴짝수연속한부분수열 {
	public static void main(String[] args) {
        FastReader rd = new FastReader();

        int N = rd.nextInt();
        int K = rd.nextInt();
        int[] array = new int[N];

        for(int i = 0; i < N; i++) {
            array[i] = rd.nextInt();
        }

        int erase_count = 0;
        int answer = 0;

        for(int i = 0, r = 0; i < N; i++) {
            while(r < N) {
                if(array[r] % 2 == 0) r ++;
                else {
                    if(erase_count == K) break;
                    erase_count ++;
                    r ++;
                }
            }
            answer = Math.max(answer, r - i - erase_count);
            if(array[i] % 2 == 1) erase_count --;
        }
        System.out.println(answer);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

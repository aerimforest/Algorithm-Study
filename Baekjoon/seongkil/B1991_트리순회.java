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

public class B1991_트리순회 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static int[][] tree;
    
    
    static void input() {
    	N = scan.nextInt();
    	tree = new int[N][2];
    	
    	for (int i = 0; i < N; i++) {

            int parentNode = scan.next().charAt(0) - 'A';
            int leftNode = scan.next().charAt(0) - 'A';
            int rightNode = scan.next().charAt(0) - 'A';

            tree[parentNode][0] = (leftNode == -19) ? -1 : leftNode;
            tree[parentNode][1] = (rightNode == -19) ? -1 : rightNode;
        }
    }
    
    static void preOrder(int s) {
        if (s == -1) return; 
        sb.append((char) (s + 'A'));
        preOrder(tree[s][0]);
        preOrder(tree[s][1]);
    }

    static void inOrder(int s) {
        if (s == -1) return;
        inOrder(tree[s][0]);
        sb.append((char) (s + 'A'));
        inOrder(tree[s][1]);
    }

    static void postOrder(int s) {
        if (s == -1) return;
        postOrder(tree[s][0]);
        postOrder(tree[s][1]);
        sb.append((char) (s + 'A'));
    }
    
    public static void main(String[] args) {
    	input();
    	
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    	    	
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
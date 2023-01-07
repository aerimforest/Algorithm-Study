import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[] parent ;
	static boolean CycleCheck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N];

		for(int i=0;i<N;i++)parent[i] = i;

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(union(a,b,i)) return;
		}
		System.out.println(0);
		}

		public static boolean union(int a,int b,int i){
			a = find(a);
			b = find(b);
			if(a==b){
				System.out.println(i+1);
				return true;
			}
			parent[b] = a;
			return false;
		}

		public static int find(int idx){
			if(parent[idx] == idx) return idx;
			parent[idx] = find(parent[idx]);
			return parent[idx];
		}
}

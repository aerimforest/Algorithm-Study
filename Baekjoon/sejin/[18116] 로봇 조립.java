import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] parent , cnt ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[1000001];
		cnt = new int[1000001];
		for (int i = 0; i < parent.length; i++){
			parent[i] = i; 
			cnt[i] = 1;
		} 

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String iq = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			if(iq.equalsIgnoreCase("I")){
				int b = Integer.parseInt(st.nextToken());
				UnionFind(a,b);
			}else{
				System.out.println(cnt[find(a)]);

			}
		}
	}

	public static void UnionFind(int a, int b){
		a = find(a);
		b = find(b);
		if(a==b)return;
		if (a<b){
			cnt[a] += cnt[b];
			cnt[b] = 0;
			parent[b] = a;
		}else{
			cnt[b] += cnt[a];
			cnt[a] = 0;
			parent[a] = b;
		}


	}

	public static int find(int x){
		if(parent[x] == x ) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}

}

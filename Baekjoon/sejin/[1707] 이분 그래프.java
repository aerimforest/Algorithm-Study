import java.io.*;
import java.util.*;

public class Main {

	static int TestCase;
	static int V,E;
	static ArrayList<Integer>[] arr;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestCase = Integer.parseInt(br.readLine());

		while(TestCase --> 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			arr = new ArrayList[V+1];
			visited = new int[V+1];

			for(int i=1;i<=V;i++) arr[i] = new ArrayList();
			
			for(int i=0;i<E;i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}

			boolean BiGraph = true;

			for(int i=1; i<=V;i++){
				if(visited[i] == 0) DFS(arr, visited, i, 1);
			} 
			
			for(int i=1; i<=V; i++){
				for(int j : arr[i]){
					if(visited[i] == visited[j]){
						BiGraph = false;
					}

				}
			}

			if(BiGraph) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	public static void DFS(ArrayList<Integer>[] arr, int[] visited, int x, int c){
		visited[x] = c ;
		for(int y : arr[x]){
			if(visited[y]==0) DFS(arr,visited,y,3-c);
		}
		
	}

}

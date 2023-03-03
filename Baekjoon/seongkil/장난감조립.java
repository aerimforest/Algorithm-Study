import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	N = scan.nextInt();
    	int M = scan.nextInt();
    	
    	int[] arr = new int[N + 1];
    	int[] in = new int[N + 1];
    	int[][] dag = new int[N + 1][N + 1];
    	boolean[] isComb = new boolean[N + 1];
    	
    	for (int i = 0; i < M; i++) {
    		int a = scan.nextInt();
    		int b = scan.nextInt();
    		
    		dag[a][b] = scan.nextInt();
    		in[b]++;
    		isComb[a] = true;
    	}
    	
    	Queue q = new LinkedList<>();
    	
    	for (int i = 1; i <= N; i++) {
    		if (in[i] == 0) {
    			q.add(i);
    			arr[i] = 1;
    		}
    	}
    	
    	while (!q.isEmpty()) {
    		int node = (int) q.poll();
    		
    		for (int i = 1; i <= N; i++) {
    			if (dag[node][i] != 0) {
    				arr[i] += arr[node] * dag[node][i];
    				in[i]--;
    				
    				if (in[i] == 0 )
    					q.add(i);
    			}
    		}
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		if (!isComb[i]) 
    			System.out.println(i + " " + arr[i]);
    	}
    	
    	
       
    }
}
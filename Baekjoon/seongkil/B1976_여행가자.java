
package Baekjoon.seongkil;
import java.io.*;
import java.util.*;

public class B1976_여행가자 {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N];
        for(int i = 0; i<N; i++)
            parent[i] = i;

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num == 1)
                    union(i, j);
            }
        }

        int[] trip = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++)
            trip[i] = Integer.parseInt(st.nextToken())-1;

        boolean canGo = true;
        for(int i = 0; i<M-1; i++){
            if(union(trip[i], trip[i+1]))
                canGo = false;
        }

        if(canGo)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static int find(int idx){
        if(parent[idx] == idx)
            return idx;
        else
            return find(parent[idx]);
    }
    static boolean union(int idx1, int idx2){
        int parent1 = find(idx1);
        int parent2 = find(idx2);

        if(parent1 == parent2)
            return false;
        else{
            parent[parent2] = parent1;
            return true;
        }
    }
}
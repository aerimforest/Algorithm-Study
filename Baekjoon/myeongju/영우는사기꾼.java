import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] list;
    static int[] built;
    static int[] indegree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        built = new int[N+1];
        indegree = new int[N+1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a를 건설해야 b를 지음
            list[a].add(b);
            indegree[b]++;
        }

        String answer = "King-God-Emperor";
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            // 건설
            if(type==1) {
                if(indegree[n]==0) {
                    built[n]++;
                    if(built[n]==1) {
                        for(int b : list[n])
                            indegree[b]--;
                    }
                }
                else {
                    answer = "Lier!";
                    break;
                }
            }
            // 파괴
            else {
                if(built[n]==0) {
                    answer = "Lier!";
                    break;
                }
                else {
                    built[n]--;
                    if(built[n]==0) {
                        for(int b : list[n])
                            indegree[b]++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
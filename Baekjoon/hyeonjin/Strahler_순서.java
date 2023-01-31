import java.io.*;
import java.util.*;

public class Strahler_순서 {
    static List<Integer>[] river;
    static int K;
    static int M;
    static int P;
    static int[] order;
    static int[] maxCnt;
    static int[] inter;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int T = Integer.valueOf(br.readLine());
        for(int t = 1; t <= T; t++) {
            str = new StringTokenizer(br.readLine());
            K = Integer.valueOf(str.nextToken());
            M = Integer.valueOf(str.nextToken());
            P = Integer.valueOf(str.nextToken());

            order = new int[M + 1];
            maxCnt = new int[M + 1];
            inter = new int[M + 1];
            river = new List[M + 1];
            for (int i = 1; i <= M; i++) {
                river[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                str = new StringTokenizer(br.readLine());
                int A = Integer.valueOf(str.nextToken());
                int B = Integer.valueOf(str.nextToken());

                river[A].add(B);
                inter[B]++;
            }

            flowRiver();
            getResult();

            System.out.println(t + " " + result);
        }
    }

    private static void flowRiver() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= M; i++){
            if(inter[i] == 0) {
                queue.add(i);
                order[i]++;
                maxCnt[i]++;
            }
        }

        while(!queue.isEmpty()){
            int q = queue.poll();

            if(maxCnt[q] >= 2) order[q]++;

            for(int target : river[q]){
                inter[target]--;

                if(inter[target] == 0) queue.add(target);

                if(order[q] == order[target]) maxCnt[target]++;
                else if(order[target] < order[q]){
                    order[target] = order[q];
                    maxCnt[target] = 1;
                }
            }
        }
    }

    public static void getResult() {
        result = 0;
        for(int i = 1; i <= M; i++){
            result = Math.max(order[i], result);
        }
    }
}

import java.io.*;
import java.util.*;

public class 장난감_조립 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int M = Integer.valueOf(br.readLine());
        boolean[] notBasic = new boolean[N + 1];
        int[] value = new int[N + 1];
        List<Part>[] parent = new List[N + 1];
        for(int i = 0; i <= N; i++){
            parent[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int X = Integer.valueOf(str.nextToken());
            int Y = Integer.valueOf(str.nextToken());
            int K = Integer.valueOf(str.nextToken());

            parent[Y].add(new Part(X, K, 0));
            notBasic[X] = true;
        }

        Queue<Part> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(!notBasic[i]) {
                queue.add(new Part(i, 1, i));
                while(!queue.isEmpty()){
                    Part target = queue.poll();
                    if(target.idx == N) {
                        value[target.start] += target.value;
                        continue;
                    }

                    for(Part part : parent[target.idx]){
                        queue.add(new Part(part.idx, part.value * target.value, target.start));
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(value[i] > 0) System.out.println(i + " " + value[i]);
        }
    }

    public static class Part{
        int idx;
        int value;
        int start;
        public Part(int idx, int value, int start){
            this.idx = idx;
            this.value = value;
            this.start = start;
        }
    }
}

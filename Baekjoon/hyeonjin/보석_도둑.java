import java.io.*;
import java.util.*;

public class 보석_도둑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        int[] bag = new int[K];

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }

        for(int i = 0 ; i < K; i++){
            bag[i] = Integer.valueOf(br.readLine());
        }

        Collections.sort(jewels);
        Arrays.sort(bag);

        int jewelIndex = 0;
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < K; i++){
            int num = bag[i];

            while(jewelIndex < N && jewels.get(jewelIndex).m <= num){
                pq.add(jewels.get(jewelIndex++).v);
            }

            if(!pq.isEmpty()) result += pq.poll();
        }

        System.out.println(result);
    }

    static class Jewel implements Comparable<Jewel>{
        int m;
        int v;

        public Jewel(int m, int v){
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o){
            return m - o.m;
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static List<Load> load;
    static int[] check;
    static int sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        while(true) {
            str = new StringTokenizer(br.readLine());
            M = Integer.valueOf(str.nextToken()); //집의 수
            N = Integer.valueOf(str.nextToken()); //길의 수

            if(M == 0 && N == 0) return;

            check = new int[N];
            load = new ArrayList<>();
            sum = 0;
            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(str.nextToken());
                int y = Integer.valueOf(str.nextToken());
                int z = Integer.valueOf(str.nextToken());
                load.add(new Load(x, y, z));
                check[i] = i;
                sum += z;
            }

            Collections.sort(load);
            kruskal();
        }
    }

    private static void kruskal() {
        List<Load> minLoad = new ArrayList<>();

        for(int i  = 0; i < load.size(); i++){
            Load target = load.get(i);

            //Union-Find를 이용해서 사이클이 발생하는지 확인
            if(find_root(target.x) == find_root(target.y)) continue;

            minLoad.add(target);
            union_root(target);

            if(minLoad.size() == M - 1) {
                int result = 0;
                for(int j = 0; j < minLoad.size(); j++){
                    result += minLoad.get(j).z;
                }
                System.out.println(sum - result);
                return;
            }
        }
    }

    private static void union_root(Load target) {
        int x = find_root(target.x);
        int y = find_root(target.y);

        if(x != y) check[y] = x;
    }

    private static int find_root(int x) {
        if(check[x] == x) return x;

        return check[x] = find_root(check[x]);
    }


    public static class Load implements Comparable<Load> {
        int x;
        int y;
        int z;
        public Load(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Load l){
            return z - l.z;
        }
    }
}

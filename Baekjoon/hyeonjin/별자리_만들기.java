import java.io.*;
import java.util.*;

public class Main {
    static List<Distance> distance;
    static int[] check;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        List<Point> star = new ArrayList<>();
        distance = new ArrayList<>();
        check = new int[N];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            star.add(new Point(Double.valueOf(str.nextToken()), Double.valueOf(str.nextToken()), i));
            check[i] = i;
        }

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                distance.add(new Distance(star.get(i), star.get(j)));
            }
        }

        Collections.sort(distance);
        kruskal();
    }

    private static void kruskal() {
        List<Distance> result = new ArrayList<>();
        for(int i = 0; i < distance.size(); i++){
            Distance dist = distance.get(i);

            if(find_root(dist.p1.index) == find_root(dist.p2.index)) continue;

            union_root(dist);
            result.add(dist);

            if(result.size() == N - 1){
                double sum = 0;
                for(int j = 0; j < result.size(); j++){
                    sum += result.get(j).distance;
                }

                System.out.println(sum);
                return;
            }
        }
    }

    public static void union_root(Distance dist){
        int x = find_root(dist.p1.index);
        int y = find_root(dist.p2.index);

        if(x != y) check[y] = x;
    }

    public static int find_root(int x){
        if(check[x] == x) return x;
        return check[x] = find_root(check[x]);
    }


    public static class Point{
        double x;
        double y;
        int index;
        public Point(double x, double y, int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static class Distance implements Comparable<Distance>{
        Point p1;
        Point p2;
        double distance;
        public Distance(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
            this.distance = Math.round(Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)) * 100) / 100.0;
        }

        @Override
        public int compareTo(Distance o){
            return Double.compare(this.distance, o.distance);
        }
    }
}

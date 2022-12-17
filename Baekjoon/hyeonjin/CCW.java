import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Point> points;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        points = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            str = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }
        int num = calc();
        System.out.println(Integer.compare(num, 0));
    }

    private static int calc() {
        return ((points.get(1).x - points.get(0).x) * (points.get(2).y - points.get(1).y))
                - ((points.get(2).x - points.get(1).x) * (points.get(1).y - points.get(0).y));
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

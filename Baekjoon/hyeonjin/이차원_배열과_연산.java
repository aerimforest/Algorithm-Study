import java.io.*;
import java.util.*;

public class 이차원_배열과_연산 {
    static int R;
    static int C;
    static int K;
    static int[][] arr;
    static int result = 0;
    static int cnt_R;
    static int cnt_C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());
        K = Integer.valueOf(str.nextToken());
        R--;
        C--;

        arr = new int[100][100];
        for(int i = 0; i < 3; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        calculation();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void calculation() {
        while(arr[R][C] != K){

            if(result > 100) {
                result = -1;
                break;
            }

            result++;

            countRowAndCol();

            if(cnt_R >= cnt_C) {
                //R 연산
                for (int i = 0; i < 100; i++) {
                    calc_R(i);
                }
            }
            else {
                //C 연산
                for (int i = 0; i < 100; i++) {
                    calc_C(i);
                }
            }
        }
    }

    private static void countRowAndCol() {
        cnt_C = 0;
        cnt_R = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(arr[i][j] != 0) {
                    cnt_R = Math.max(cnt_R, i + 1);
                    cnt_C = Math.max(cnt_C, j + 1);
                }
            }
        }
    }

    private static void calc_C(int index){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < 100; i++){
            int value = arr[i][index];

            if(value == 0) continue;

            if(map.containsKey(value)) map.put(value, map.get(value) + 1);
            else map.put(value, 1);
        }

        List<Point> points = new ArrayList<>();
        for(int v : map.keySet()){
            points.add(new Point(v, map.get(v)));
        }
        Collections.sort(points);

        int i = 0;

        for(Point p : points){
            arr[i][index] = p.x;
            i++;
            arr[i][index] = p.count;
            i++;

            if(i >= 100) break;
        }

        for(int j = i; j < 100; j++){
            arr[j][index] = 0;
        }
    }

    private static void calc_R(int index){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < 100; i++){
            int value = arr[index][i];

            if(value == 0) continue;

            if(map.containsKey(value)) map.put(value, map.get(value) + 1);
            else map.put(value, 1);
        }


        List<Point> points = new ArrayList<>();
        for(int v : map.keySet()){
            points.add(new Point(v, map.get(v)));
        }
        Collections.sort(points);

        int i = 0;
        for(Point p : points){
            arr[index][i] = p.x;
            i++;
            arr[index][i] = p.count;
            i++;

            if(i >= 100) break;
        }

        for(int j = i; j < 100; j++){
            arr[index][j] = 0;
        }
    }

    private static class Point implements Comparable<Point>{
        int x;
        int count;

        public Point(int x, int count){
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(Point o){
            if(count != o.count) return this.count - o.count;
            return this.x - o.x;
        }
    }
}

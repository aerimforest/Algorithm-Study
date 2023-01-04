import java.io.*;
import java.util.*;

public class 로봇_조립 {
    static int[] robot;
    static int[] count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        robot = new int[1_000_001];
        count = new int[1_000_001];

        for(int i = 0; i <= 1_000_000; i++){
            robot[i] = i;
            count[i] = 1;
        }

        int N = Integer.valueOf(br.readLine());

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            if(str.nextToken().equals("I")){
                int x = Integer.valueOf(str.nextToken());
                int y = Integer.valueOf(str.nextToken());

                if(x < y) union_root(x ,y);
                else union_root(y, x);
            }
            else{
                int num = Integer.valueOf(str.nextToken());
                bw.write(String.valueOf(count[find_root(num)]));
                bw.newLine();
            }
        }

        bw.flush();
    }

    private static int find_root(int x){
        if(x == robot[x]) return x;
        else return robot[x] = find_root(robot[x]);
    }

    private static void union_root(int x, int y) {
        int xx = find_root(x);
        int yy = find_root(y);

        if(xx != yy) {
            robot[yy] = xx;
            count[xx] += count[yy];
        }
    }
}

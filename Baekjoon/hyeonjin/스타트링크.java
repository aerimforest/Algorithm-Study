import java.io.*;
import java.util.*;

public class 스타트링크 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int F = Integer.valueOf(str.nextToken()); // 최대 F층
        int S = Integer.valueOf(str.nextToken()); // 현재 위치
        int G = Integer.valueOf(str.nextToken()); // 스타트링크 위치
        int U = Integer.valueOf(str.nextToken()); // 위로
        int D = Integer.valueOf(str.nextToken()); // 아래로

        boolean[] check = new boolean[F + 1];

        Queue<Integer> queue = new LinkedList<>();
        check[S] = true;
        queue.add(S);

        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int num = queue.poll();

                if(num == G) {
                    System.out.println(cnt);
                    return;
                }

                //아래로
                int down = num - D;
                if (down > 0 && !check[down]) {
                    queue.add(down);
                    check[down] = true;
                }

                //위로
                int up = num + U;
                if (up <= F && !check[up]) {
                    queue.add(up);
                    check[up] = true;
                }
            }
            cnt++;
        }

        System.out.println("use the stairs");
    }
}

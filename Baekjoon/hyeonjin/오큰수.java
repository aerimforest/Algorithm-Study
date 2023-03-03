import java.io.*;
import java.util.*;

public class 오큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        int[] result = new int[N];
        str = new StringTokenizer(br.readLine());
        Stack<Point> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int num = Integer.valueOf(str.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek().value >= num) break;

                result[stack.peek().index] = num;
                stack.pop();
            }

            stack.push(new Point(i, num));
        }

        while(!stack.isEmpty()){
            Point target = stack.pop();
            result[target.index] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static class Point{
        int index;
        int value;

        public Point(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}

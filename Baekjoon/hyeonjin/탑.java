import java.io.*;
import java.util.*;

public class 탑 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        arr = new int[N + 1];

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        String result = checkLaser();
        System.out.println(result);
    }

    private static String checkLaser() {
        Stack<Top> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= N; i++){
            while(true){
                if(stack.isEmpty()){
                    sb.append("0 ");
                    stack.add(new Top(i, arr[i]));
                    break;
                }

                Top top = stack.peek();

                if(top.height > arr[i]){
                    sb.append(top.index + " ");
                    stack.push(new Top(i, arr[i]));
                    break;
                }

                stack.pop();
            }
        }
        return sb.toString();
    }

    public static class Top{
        int index;
        int height;

        public Top(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
}

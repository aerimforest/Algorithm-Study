import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int K = Integer.valueOf(str.nextToken());

        if(N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        boolean[] check = new boolean[200_001];
        int[] preIndex = new int[200_001];
        Arrays.fill(preIndex, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = true;
        StringBuffer sb = new StringBuffer();
        int time = 0;
        while(!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int num = queue.poll();

                if(num + 1 < 200_000 && num + 1 == K) {
                    System.out.println(time);
                    sb.append(num + 1);
                    while(num != -1) {
                        sb.insert(0, num + " ");
                        num = preIndex[num];
                    }
                    System.out.println(sb.toString());
                    return;
                }
                else if(num + 1 < 200_000 && !check[num + 1]) {
                    queue.add(num + 1);
                    preIndex[num + 1] = num;
                    check[num + 1] = true;
                }

                if(num - 1 >= 0 && num - 1 == K) {
                    System.out.println(time);
                    sb.append(num - 1);
                    while(num != -1) {
                        sb.insert(0, num + " ");
                        num = preIndex[num];
                    }
                    System.out.println(sb.toString());
                    return;
                }

                else if(num - 1 >= 0 && !check[num - 1]) {
                    queue.add(num - 1);
                    preIndex[num - 1] = num;
                    check[num - 1] = true;
                }

                if(num * 2 < 200_000 && num * 2 == K) {
                    System.out.println(time);
                    sb.append(num * 2);
                    while(num != -1) {
                        sb.insert(0, num + " ");
                        num = preIndex[num];
                    }
                    System.out.println(sb.toString());
                    return;
                }
                else if(num * 2 < 200_000 && !check[num * 2]) {
                    queue.add(num * 2);
                    preIndex[num * 2] = num;
                    check[num * 2] = true;
                }
            }
        }
    }
}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] check;
    static int dot;
    static int line;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int testCase = Integer.valueOf(str.nextToken());

        for(int t = 0; t < testCase; t++){
            str = new StringTokenizer(br.readLine());
            dot = Integer.valueOf(str.nextToken());
            line = Integer.valueOf(str.nextToken());
            check = new int[dot + 1];
            arr = new ArrayList[dot + 1];
            for(int i = 1; i <= dot; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i = 0; i < line; i++){
                str = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(str.nextToken());
                int b = Integer.valueOf(str.nextToken());
                arr[a].add(b);
                arr[b].add(a);
            }

            String result = checkGraph();
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
    }

    private static String checkGraph() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i  = 1; i <= dot; i++){
            if(check[i] == 0){
                queue.add(i);
                check[i] = 1;
            }

            while(!queue.isEmpty()){
                int num = queue.poll();

                for(int j = 0; j < arr[num].size(); j++){
                    int target = arr[num].get(j);
                    if(check[target] == check[num])
                        return "NO";

                    if(check[target] == 0){
                        queue.add(target);
                        if(check[num] == 1)
                            check[target] = 2;
                        else
                            check[target] = 1;
                    }
                }
            }
        }

        return "YES";
    }
}

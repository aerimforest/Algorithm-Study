import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static ArrayList<Node>[] arr;
    static boolean[] check;
    static int selectNode;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int dotNum = Integer.valueOf(str.nextToken());
        arr = new ArrayList[dotNum + 1];
        for(int i = 1; i <= dotNum; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < dotNum; i++){
            str = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(str.nextToken());
            while(true){
                int point = Integer.valueOf(str.nextToken());
                if(point == -1) break;
                int cost = Integer.valueOf(str.nextToken());
                arr[num].add(new Node(point, cost));
            }
        }

        check = new boolean[dotNum + 1];
        dfs(1,0);

        check = new boolean[dotNum + 1];
        dfs(selectNode,0);

        System.out.println(max);
    }

    private static void dfs(int point, int depth) {
        if(depth > max){
            max = depth;
            selectNode = point;
        }

        check[point] = true;

        for(int i = 0; i < arr[point].size(); i++){
            Node node = arr[point].get(i);
            if(!check[node.dot]){
                dfs(node.dot, depth + node.cost);
                check[node.dot] = true;
            }
        }
    }

    public static class Node{
        int dot;
        int cost;

        public Node(int dot, int cost){
            this.dot = dot;
            this.cost = cost;
        }
    }
}

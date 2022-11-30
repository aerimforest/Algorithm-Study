import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(str.nextToken());
        int end = Integer.valueOf(str.nextToken());
        int max = 100_000;
        int time = Integer.MAX_VALUE;
        boolean[] check = new boolean[max + 1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            Node n = q.poll();
            check[n.x] = true;
            if(n.x == end) time = Math.min(time, n.time);

            if(n.x * 2 <= max && !check[n.x * 2]) q.add(new Node(n.x * 2, n.time));
            if(n.x + 1 <= max && !check[n.x + 1]) q.add(new Node(n.x + 1, n.time + 1));
            if(n.x - 1 >= 0 && !check[n.x - 1]) q.add(new Node(n.x - 1, n.time + 1));
        }

        System.out.println(time);
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}

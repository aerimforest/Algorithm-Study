import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<Node>[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int house = Integer.valueOf(str.nextToken());
        int load = Integer.valueOf(str.nextToken());
        arr = new ArrayList[house + 1];
        for(int i = 1; i <= house; i++){
            arr[i] = new ArrayList<>();
        }


        for(int i = 0; i < load; i++){
            str = new StringTokenizer(br.readLine());
            int house1 = Integer.valueOf(str.nextToken());
            int house2 = Integer.valueOf(str.nextToken());
            int value = Integer.valueOf(str.nextToken());
            arr[house1].add(new Node(house2, value));
            arr[house2].add(new Node(house1, value));
        }

        System.out.println(findMin(house));

    }

    private static int findMin(int house) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int count = 0;
        int min = 0;
        int maxValue = 0;
        boolean[] check = new boolean[house + 1];

        q.add(new Node(1,0));

        while(count < house){
            Node node = q.poll();
            if(check[node.x]) continue;

            check[node.x] = true;
            count++;
            min += node.value;
            maxValue = Math.max(maxValue, node.value);

            for(Node n : arr[node.x]){
                if(!check[n.x]) q.add(n);
            }
        }

        return min - maxValue;
    }

    public static class Node implements Comparable<Node> {
        int x;
        int value;
        public Node(int x, int value){
            this.x = x;
            this.value = value;
        }

        @Override
        public int compareTo(Node e){
            return this.value - e.value;
        }
    }
}

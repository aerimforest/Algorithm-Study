import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class node implements Comparable<node> {
    int start;
    int end;
    int cost;
 
    public node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
 
    @Override
    public int compareTo(node o) {
        return this.cost - o.cost;
    }
}
 
public class Main {
    static int n, m;
    static int[] parent;
    static long result;
    static int max;
    static PriorityQueue<node> queue = new PriorityQueue<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
 
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
 
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);
            int cost = Integer.parseInt(s1[2]);
            queue.add(new node(start, end, cost));
        }
 
        while (!queue.isEmpty()) {
            node poll = queue.poll();
            if (!isParent(poll.start, poll.end)) {
                union(poll.start, poll.end);
                result += poll.cost;
                max = poll.cost;
            }
        }
        System.out.println(result - max);
    }
 
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
 
    public static boolean isParent(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp != yp) {
            return false;
        } else {
            return true;
        }
    }
 
    public static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        parent[yp] = xp;
    }
}

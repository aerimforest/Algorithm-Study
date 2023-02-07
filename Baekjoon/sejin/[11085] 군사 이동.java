import java.util.*;

import javax.imageio.ImageIO;

import java.io.*;

// 1 -> 2,3 을 가는데 그 중 더  큰 값   ,
// 전체에서는 제일 작은 값 출력

class Node implements Comparable<Node>{
    int x, y , width ; 
    Node(int x, int y , int width){
        this.x = x ;
        this.y = y ;
        this.width = width;
    }
    public int compareTo(Node o){
        return o.width - width;
    }
}
 
class Main {
    static int P, W, start , end ; //p개의 지점, w개의 길, 시작, 끝
    static int[] parent , rank ;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = stoi(st.nextToken()); // P개의 지점
        W = stoi(st.nextToken()); // W개의 길 

        st = new StringTokenizer(br.readLine());
        start = stoi(st.nextToken()); // B.W 수도
        end = stoi(st.nextToken()); // C.W 수도

        parent = new int[P];
        rank = new int[P];
        for(int i=0;i<P;i++)parent[i] = i ;

        for(int i=0;i<W;i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()); 
            int y = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            pq.add(new Node(x, y, w));
        }
        // <--


        mst();

    }

    public static void mst(){
        
        int lastWidth = 1001;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            lastWidth = node.width;

            merge(node.x, node.y);
            if (!((parent[start] == start) && (parent[end] == end)) && (find(start) == find(end))) break;
        }

        System.out.print(lastWidth);
    }

    public static void merge(int a, int b ){
        a = find(a);
        b = find(b);
        if(a==b) return ;
        if(rank[a] < rank[b]) parent[a] = b ;
        else{
            parent[b] = a ;
            if(rank[a] == rank[b]) rank[a] ++ ; 
        }

    }

    public static int find(int idx){
        if(parent[idx] == idx ) return idx ;
        return find(parent[idx]);
    }
}




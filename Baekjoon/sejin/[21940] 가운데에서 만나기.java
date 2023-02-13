import java.util.*;
import java.io.*;

// 1. 현재 map 에서 다익스트라
// 2. reverse Map 에서 다익스트라
// 3. map + reverse Map 최대값 구하기
// 4. 3 중 최소값 구하기
// 5. 그 최소값으로 갈 수 있는 마을 구하기

class Main {
    static int N, M; // 도시 수, 도로 수
    static ArrayList<Node>[] map;
    static int K ; // 총 인원
    static int[] cityNum; // 전원이 살고있는 도시 번호
    static StringBuilder sb ;
    static int[][] distance ;
    static int INF = 20000001;

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new ArrayList[M];

        for(int i=0;i<N;i++) map[i] = new ArrayList<>();
 
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken())-1 ;
            int y = stoi(st.nextToken())-1 ;
            int z = stoi(st.nextToken());
            map[x].add(new Node(y,z));
        }

        // 총인원, 살고있는 도시 번호
        K = stoi(br.readLine());
        cityNum = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            cityNum[i] = stoi(st.nextToken())-1; // i번째 친구가 (들어온값)에 살고있음
        }
        // <--

        // 1 ~ N 번까지의 마을을 전체 탐색하여 전체 친구들의 왕복시간이 최소가 될 때의 마을을 출력
        // 한 정점 -> 다른 모든 정점 (< 배열 반대로 > ) 한정점 -> 다른 모든 정점 
        // 다익스트라 알고리즘 !!!

        distance = new int[N][N]; // 모든 정점의 최단경로를 담음
        
        // 다익스트라로 모든 정점의 최단 경로를 구함
        for(int i=0;i<N;i++){ 
            int[] dist = new int[N];
            dist = dijkstra(i); // 현재 정점(i)의 최단거리
            for(int j=0;j<N;j++) distance[i][j] = dist[j];
        }

        // 왕복거리의 최대 거리를 찾음, 그 중 최솟값
        int[] max = new int[N]; 
        int MinResult = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            for(int j : cityNum){
                max[i] = Math.max(max[i], distance[i][j] + distance[j][i]);
            }
            MinResult = Math.min(MinResult, max[i]);
        }

        sb = new StringBuilder();

        for(int i=0;i<N;i++){
            if(MinResult >= max[i]) sb.append((i+1)+" ");
        }
        System.out.print(sb.toString());
    }


    public static int[] dijkstra(int start){
        int[] dists = new int[N];
        Arrays.fill(dists, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.dist, o2.dist)));
        pq.offer((new Node(start, 0)));
        dists[start] = 0 ;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIdx = curNode.idx;
            int curDist = curNode.dist; 

            for(Node nxt : map[curIdx]){
                if(dists[nxt.idx] < curDist) continue;
                if(dists[nxt.idx] > curDist + nxt.dist){
                    dists[nxt.idx] = curDist + nxt.dist;
                    pq.add(new Node(nxt.idx, dists[nxt.idx]));
                }
            }
        }

        return dists ;
    }
}

class Node{
    int idx, dist ;
    Node(int idx,int dist){
        this.idx = idx ; 
        this.dist = dist ;
    }
}




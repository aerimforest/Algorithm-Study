import java.io.*;
import java.util.*;

// 문제 요약
// 여우 = 동일 속도, 늑대 = 출발 *1/2배 -> *2배 -> 1/2배 -> *2배
// 여우가 늑대보다 빨리 도착할 수 있는 그루터기의 개수

// 해결 방법
// 1. 여우 최소 distance 구하고
    // 다익스트라로 최소 dist 
// 2. 늑대 최소 distance 구한 후 비교해서 출력
    // 늑대는 속도가 계속 달라지는데 이를 어떻게 해결할 것인가?
    // 2-1. graph 배열 입력받을 때 늑대 배열 따로 홀*2, 짝/2 로 입력받기 => 늑대의 출발지에 따라 경우의 수가 다양하기 때문에 성립X
    // 2-2. 늑대 Node 정보에 count 변수 추가, 다음 갈 때 마다 +1 해서 count 홀수일 때 1/2, 짝수일 때 *2 => X ( 답이 다르게 나와 해결하지 못했음ㅠ)
    // ✓ 2-3. 늑대 dist 배열을 [2][N]으로 생성하여, 0일 때 /2 , 1일 때 *2로 계산

// 주의. 늑대가 1/2배로 갈 경우 double 형 방지를 위해 거리 입력받을 때 *2

class Node{
    int idx, cost, count;
    Node(int idx, int cost, int count){
        this.idx = idx;
        this.cost = cost;
        this.count = count;
    }
}

public class Main {

    static int N,M; // N = 나무 그터터기 개수 , M = 오솔길의 개수 
    static ArrayList<Node>[] graph; // 오솔길 정보,속도
    static int[] FoxDist; // 여우 거리
    static int[][] WolfDist; // 늑대 거리 [0][i] : 1/2배 속도, [1][i]: 2배 속도

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for(int i=0;i<N;i++) graph[i] = new ArrayList();
        FoxDist = new int[N];
        Arrays.fill(FoxDist, Integer.MAX_VALUE);

        WolfDist = new int[2][N];
        Arrays.fill(WolfDist[0], Integer.MAX_VALUE);
        Arrays.fill(WolfDist[1], Integer.MAX_VALUE);        

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1; // a번 그루터기
            int b = Integer.parseInt(st.nextToken())-1; // b번 그루터기
            int d = Integer.parseInt(st.nextToken())*2; // a와b 사이에 길이가 d인 오솔길, 늑대가 절반 거리로 갈 경우 double형을 방지하고자 *2
            graph[a].add(new Node(b,d,0)); 
            graph[b].add(new Node(a,d,0));
        }
        
        dijkstra();
        WolfDijkstra();
        int ans = 0;
        for(int i=0;i<N;i++){
            if(FoxDist[i] < Math.min(WolfDist[0][i],WolfDist[1][i])) ans+=1;
        }
        System.out.println(ans);
    }

    public static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.cost,o2.cost));
        q.offer(new Node(0,0,0));
        FoxDist[0] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(FoxDist[cur.idx] < cur.cost) continue;
            for(Node next : graph[cur.idx]){
                int nW = cur.cost + next.cost;
                if(FoxDist[next.idx]> nW){
                    FoxDist[next.idx] = nW;
                    q.offer(new Node(next.idx, FoxDist[next.idx],0));
                }
            }
        }
    }

    public static void WolfDijkstra(){
        PriorityQueue<Node> wolfq = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        wolfq.offer(new Node(0,0,0));
        WolfDist[0][0] = 0;
        // WolfDist[1][0] = 0;

        while(!wolfq.isEmpty()){
            Node cur = wolfq.poll();
            if(WolfDist[cur.count][cur.idx]<cur.cost) continue; // 현재 비용보다 값이 작은 경우 리턴

            for(Node nNode : graph[cur.idx]){
                int nIdx = nNode.idx; // 다음 이동할 노드 인덱스
                int nW = cur.cost;
                int curC = cur.count; // 현재 노드의 카운트(0,1)
                int nxtC = nNode.count; //다음 노드의 카운트(1,0)

                if(curC == 0) {
                    nW += nNode.cost/2 ; // 홀수일 때 /2 (빠르게 가는 경우)
                    nxtC = 1;
                }else {
                    nW += nNode.cost*2 ; //짝수일 때 *2 (느리게 가는 경우)
                    nxtC = 0;
                }

                if(WolfDist[nxtC][nIdx] > nW){ 
                    WolfDist[nxtC][nIdx] =nW;
                    wolfq.offer(new Node(nIdx, WolfDist[nxtC][nIdx], nxtC));
                }
            }
        }
    }
}


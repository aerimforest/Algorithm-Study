import java.io.*;
import java.util.*;

// K개의 가방(무게)에 최대 1개 보석(무게,가격)을 훔쳐서 달아날 때 최대 보석 가격
// 가방과 보석의 최대 개수가 30만 * 30만 = 900억...
    // => 가격 높은순대로 정렬 후 이분탐색 : 시간초과 -> 우선순위 

class Node implements Comparable<Node>{
    int weight, cost ;
    Node(int weight, int cost){
        this.weight = weight;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        if (this.weight == o.weight){
            return o.cost - this.cost; // 가격는 내림차순
        }else return this.weight - o.weight; // 무게는 오름차순
    }
}

public class Main {

    static int N,K;
    static int[] bagWeights ;
    static Node[] arr ;
    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // N개의 보석
        K = stoi(st.nextToken()); // K개의 가방
        arr = new Node[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(stoi(st.nextToken()),stoi(st.nextToken()) );
        }
        Arrays.sort(arr); // 무게(오), 가격(내) 정렬

        // 높은 애들 먼저 계산하면 낮은 애들이 못받는 경우가 발생 -> 가방무게 입력받고 오름차순 정렬
        bagWeights = new int[K];
        for(int i=0;i<K;i++) bagWeights[i] =  stoi(br.readLine());
        Arrays.sort(bagWeights);

        // 비용은 내림차순으로 정렬하여 최대 비용이 출력되게
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long allCosts = 0 ;

        // i = 현재 가방, idx = 현재 보석
        for(int i=0,idx=0; i<K; i++){
            
            while(idx < N && arr[idx].weight <= bagWeights[i]){
                pq.offer(arr[idx++].cost);
            }

            if(!pq.isEmpty()) allCosts += pq.poll();
        }
        System.out.println(allCosts);
    }
}

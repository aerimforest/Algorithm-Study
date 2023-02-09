import java.util.*;
import java.io.*;
 
class Main {
    static int N, M;  // 도시 수, 버스 수
    static int[][] distance ; 
    static int INF = 100000001;

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        M = stoi(br.readLine());
        distance = new int[N][N];

        for(int i=0;i<N;i++) Arrays.fill(distance[i], INF );

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()) -1;
            int y = stoi(st.nextToken()) -1;
            int dist = stoi(st.nextToken());
            distance[x][y] = Math.min(distance[x][y] , dist );
        }
        // <--

        Floyd();
        // 출력
        print();

    }

    public static void Floyd(){
        for(int k=0;k<N;k++){ // 각 도시마다 최단거리 구해야 함, k=중간노드로 설정하여 거쳐가도록
            for(int i=0;i<N;i++){ // 출발
                for(int j=0;j<N;j++){ // 도착
                    if(i==j) distance[i][j] = 0 ; 
                    // min(현재거리, 출발->중간노드, 중간노드->끝)
                    distance[i][j] = Math.min(distance[i][j],distance[i][k] + distance[k][j]);
                }
            }
        }
    }

    public static void print(){
        // 98% 틀렸습니다 : 무한대 >= 일 때  0 으로 예외처리X
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(distance[i][j] >= INF ) sb.append(0 + " ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}


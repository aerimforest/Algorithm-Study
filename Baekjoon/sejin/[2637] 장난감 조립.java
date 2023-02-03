import java.util.*;
import java.io.*;
 
// 장난감 완제품 : 기본 부품 + 중간 부품으로 제작
// 기본 부품 : 문제에서 주어짐, 변형X
// 중간 부품 : 기본 부품 또는 중간 부품을 통해 생산 

// 시간제한 1초, (3 <= N <= 100 )

// 위상정렬은 진입차수가 0인 간선을 넣는 방식인데, 0이면 갈 간선이 없다는 뜻으로 갈 곳이 없음 ...
// countArr[x] 를 넣었는데, Y 를 넣어야 함 !!!!

class Main {
    static int N; // 1~N-1 : 부품의 번호 , N : 완제품의 번호
    static int M ; // M개의 줄에 부품 정보

    static int[][] PartArr ; // 부품정보
    static int[] Indegree; // 간선들의 진입차수
    static int[] result ; // 필요한 부품 결과값
    static boolean[] isComb ; // 기본부품인 지 확인

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine()); 
        M = stoi(br.readLine()); 
        PartArr = new int[N][N];
        Indegree = new int[N];
        result = new int[N];
        isComb = new boolean[N];
 
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // X,Y,K , X 를 만드는데 Y가 K개 필요함
            int X = stoi(st.nextToken())-1;
            int Y = stoi(st.nextToken())-1; 
            int K = stoi(st.nextToken());
            PartArr[X][Y] = K ;
            Indegree[Y] ++ ; // 부품의 진입차수 ++ 
            isComb[X] = true; // 생산이 이루어졌으므로 기본제품X
        }

        Topology();

        for(int i=0;i<N;i++){
            // 기본부품일 경우 출력
            if(!isComb[i]) System.out.println((i+1) + " " + result[i]);
        }
     }

     public static void Topology(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(Indegree[i]==0){
                q.add(i);
                result[i] = 1 ;
            }
        }

        while(!q.isEmpty()){
            int idx = q.poll();

            for(int i=0;i<N;i++){
                if(PartArr[idx][i] != 0){
                    result[i] += result[idx] * PartArr[idx][i];
                    Indegree[i] -- ;

                    if(Indegree[i] == 0 ) q.add(i);
                }
            }
        }
       
     }
}

import java.util.*;
import java.io.*;
 
class Main {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    // 재귀를 통한 x-1, x+1, 2*x 반복
    // 최대값인 경우 100000! 이므로 완전탐색은 흠 ...

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        // <--

        FindWayBFS();

        // parent 와 time을 이용하여 경로 역추적
        // 역추적이므로 스택사용 (LIFO)
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int idx = K ;
        
        while(idx != N){
            stack.push(parent[idx]);
            idx = parent[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time[K]-1).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());

    }

    public static void FindWayBFS(){

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1 ;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K) return ;
            
            for(int i=0;i<3;i++){
                int nxt ;
                if(i==0) nxt = now -1 ;
                else if (i == 1 ) nxt = now + 1;
                else nxt = now * 2 ;

                if(nxt < 0 || nxt > 100000 ) continue ; // 영역 벗어난 경우
                if(time[nxt] == 0 ){ // 아직 방문하지 않았다면
                    q.add(nxt); // 방문하기
                    time[nxt] = time[now] + 1 ; // 시간 + 1
                    parent[nxt] = now ; // 경로 표시
                }
            }
        }
    }
}



import java.util.*;
import java.io.*;
 
class Main {
    static int N,M,P ; // N*M 맵, P명의 플레이어 
    static int[][] map ; // '.' 빈칸, '#'벽
    static int[] PlayerMoves , result ; 
    static int AllZero = 0;
    static boolean[][] visited ;
    static boolean[] Finished ;

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        P = stoi(st.nextToken());

        PlayerMoves = new int[P+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=P; i++) PlayerMoves[i] = stoi(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M]; // 재방문X 를 위해
        result = new int[P+1]; // 플레이어마다 성 개수
        Finished = new boolean[P+1];
        Finished[0] = true ;

        for(int i=0;i<N;i++){
            char[] inputs = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if ( inputs[j] == '.') {
                    map[i][j] = 0 ; // 0 = 빈칸, 갈 수 있음
                    AllZero ++; // 해당 변수가 0 이 되면 게임 끝
                }
                else if (inputs[j] == '#') map[i][j] = -1 ; // -1 = 벽 , 못감
                else{
                    map[i][j] = inputs[j] - '0';
                    result[map[i][j]] ++ ;
                }
            }
        }
        while(true){
            if(Finish()){
                // 플레이어 수 출력
                printPlayerNum();
                break;
            }
            startGame();
        }
    }

    public static boolean Finish(){
        for(boolean now : Finished){
            if(now == false) return false ;
        }
        return true ;
    }

    static Queue<Node> q ;

    public static void startGame(){
        // 플레이어마다 게임 실행
        for(int i=1;i<=P;i++){
            q = new LinkedList<>(); // 각 플레이어의 좌표 담기
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    if(map[x][y] == i && !visited[x][y]){
                        visited[x][y] = true ;
                        q.add(new Node(x,y, PlayerMoves[i]));
                    }
                }
            }
            if(q.size() == 0 )Finished[i] = true;
            BFS(i);
        }
        
    }

    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};


    public static void BFS(int playerNum){
        // System.out.println("now player : " + playerNum);
        // printq();
        while(!q.isEmpty()){
            Node now = q.poll();
            // System.out.println(" x : " + now.x + " , y :  " + now.y+ " , count : " + now.count);
            if(now.count == 0) break;

            visited[now.x][now.y] = true ;
            for(int i=0;i<4;i++){
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];
                if(xx<0 || xx>=N || yy<0 || yy>=M || visited[xx][yy]) continue ;
                if(map[xx][yy] == 0 ){ // 빈칸일 때 만 !!
                    map[xx][yy] = playerNum ;
                    AllZero --;
                    result[playerNum] ++ ;
                    q.add(new Node(xx, yy, now.count - 1));
                }

            }
        }

    }

    public static void printPlayerNum(){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=P; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());
    }

    // public static boolean checkFinish(){
    //     for(int i=0;i<N;i++){
    //         for(int j=0;j<M;j++){
    //             if(map[i][j] == 0 ) return false;
    //         }
    //     }
    //     return true ;
    // }

    public static void checkPlayer(){
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != -1 ){
                    result[map[i][j]] += 1 ;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=P; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());
    }

    public static void printq(){
        for(Node node : q){
            System.out.println("x : " + node.x + " ,  y : " +  node.y);
        }
    }

    

}

class Node{
    int x,y, count ;
    Node(int x, int y, int count){
        this.x = x ;
        this.y = y ;
        this.count = count ;
    }
}


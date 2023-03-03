import java.util.*;
import java.io.*;
 
// 말이 4개 이상 쌓이는 순간 게임 종료, 턴 출력
// 1000 보다 크거나 종료되지 않는 경우 : -1

// 한 칸에 여러개의 말을 저장할 자료구조 : 2차원 ArrayList 했는데 ... 
// 1 2 3 인 경우 2번 말 이동할 때, 1 2 만 빼오는 방법

//  이동방향에 맞춰 말을 이동시킨 후에, 해당 맵의 색을 확인


class chess{
    int x,y,dist;
    chess(int x, int y, int dist){
        this.x = x ;
        this.y = y;
        this.dist = dist ;
    }
}

class Main {
    static int N,K,count; 
    static int[][] map ;
    static chess[] piece_info;
    static ArrayList<Integer>[][] pieces ;

    public static int stoi(String s){
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws Exception {
        // 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new int[N][N];
        piece_info = new chess[K];
        pieces = new ArrayList[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) pieces[i][j] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){ // 체스판 정보
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){ // 말 정보 : 행,열,이동 방향
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken())-1;
            int y = stoi(st.nextToken())-1;
            int dist = stoi(st.nextToken())-1;
            piece_info[i] = new chess(x, y, dist); // 말 정보에 해당 말 추가
            pieces[x][y].add(i);
        }
        
        while(true){
            if (count >= 1000){
                break;
            }
            count ++ ;
            // 말 1번부터 K번까지 이동
            MovePiece();
        }
        System.out.println(-1);
    }

    static int[] dx = {0,0,-1,1} , dy = {1,-1,0,0}; // 우좌상하
    // 상하좌우에 맞춰 이동 → 1 , ← 2 , ↑ 3 , ↓ 4
    // 말이 체스판을 벗어난 경우, 반대로 + 1
    public static void MovePiece(){
       
        for(int i=0;i<K;i++){
			// 현재좌표
            int dist = piece_info[i].dist;
            int x = piece_info[i].x;
            int y = piece_info[i].y;

			// 이동한 좌표
            int xx = x+dx[dist];
            int yy = y+dy[dist];

            // 영역을 벗어나거나, 파란색인 경우 : 방향 전환
            if(xx<0 || xx>=N || yy<0 || yy>=N || map[xx][yy] == 2 ){
                // 방향 반대로 전환
                piece_info[i].dist = (dist == 0 || dist == 1)? 1 - dist : 5-dist ;
                
                //방향 전환 후 확인
                xx = x + dx[piece_info[i].dist];
                yy = y + dy[piece_info[i].dist];
                if(xx<0 || xx >= N || yy<0 || yy>=N || map[xx][yy] == 2 ) continue ;
            
            }
            if(map[xx][yy] == 0 || map[xx][yy] == 1){
                boolean start = false ;
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0;j<pieces[x][y].size();j++){
                    int num = pieces[x][y].get(j); // 해당 위치에 있는 말의 번호
                    if(num == i){
                        start = true ;
                    }

                    if(start){
                        piece_info[num].x = xx ; // 말의 위치를 이동 좌표로 변경
                        piece_info[num].y = yy ;
                        temp.add(num);
                        pieces[x][y].remove(j); // 이전 말 위치에서 제거
                        j--;
                    }
                }

                // 좌표 갱신
                if(map[xx][yy] == 0){ // 흰색일 때
                    for(int j=0;j<temp.size();j++){
                        pieces[xx][yy].add(temp.get(j));
                    }
                }else if(map[xx][yy] == 1){ // 빨간색일 때
                    for(int j=temp.size()-1; j>=0; j--){
                        pieces[xx][yy].add(temp.get(j));
                    }
                }

                if(pieces[xx][yy].size() >=4){
                    System.out.println(count);
                    System.exit(0);
                }
            }
        }
    }
}

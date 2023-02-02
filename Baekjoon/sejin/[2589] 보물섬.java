import java.util.*;
import java.io.*;
 
// 육지 : L , 바다 : W
// 각 육지마다 제일 먼 곳의 최단 거리
// 각 육지마다 BFS .. ?
    // BFS를 한 번만 할 수 있게, 제일 먼 육지를 구할 수 있는 방법이 있을까?
 
class Main {
    static int N , M ;
    static int[][] map;
    static boolean[][] visited ;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                if(str.charAt(j)=='L')  map[i][j] = 1 ; // 1일 때 육지, 갈 수 있는 곳
                else  map[i][j] = 0 ; // 0일 때 바다, 갈 수 없음  
            }
        }
        int minDist = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 ){
                    minDist = Math.max(minDist, BFS(i,j,0));
                }
            }
        }
        System.out.println(minDist);
     }

     static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
     static int[][] dist ;

    public static int BFS(int x, int y, int ans){
        Queue<int[]> q = new LinkedList<>() ;
        dist = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(dist[i],-1);
        dist[x][y] = 0 ;
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0;i<4;i++){
                int xx = now[0] + dx[i];
                int yy = now[1] + dy[i];
                if(xx<0 || xx>=N || yy<0 || yy>=M) continue;
                if(map[xx][yy] == 1 && dist[xx][yy] == -1 ){
                    dist[xx][yy] = (dist[now[0]][now[1]] + 1) ;
                    ans = Math.max(dist[xx][yy],ans);
                    q.add(new int[]{xx,yy});
                }
                
            }
        }
        return ans ;

    }

}

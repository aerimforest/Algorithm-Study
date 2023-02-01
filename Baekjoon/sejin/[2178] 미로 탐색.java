import java.io.*;
import java.util.*;

// 1 이동 가능, 0 이동 불가능
// (1,1)에서 시작, (N,M) 까지 최소 경로
// BFS 사용

public class Main {

    static int N,M;
    static int[][] arr ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        BFS(0,0);
        
    }

    static int[] dx = {-1,0,1,0},dy = {0,1,0,-1};

    public static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,1});
        
        while(!q.isEmpty()){

            int[] now = q.poll();
            if(now[0] == N-1 && now[1] == M-1){
                System.out.println(now[2]);
                break;
            }

            for(int i=0;i<4;i++){
                int xx = now[0] + dx[i];
                int yy = now[1] + dy[i];

                if(xx<0 || xx>=N || yy<0 || yy>=M ) continue ;
                if(arr[xx][yy] == 1 ){
                    arr[xx][yy] = 0 ;
                    q.add(new int[]{xx,yy,now[2]+1});
                }

            }
        }
    }
}

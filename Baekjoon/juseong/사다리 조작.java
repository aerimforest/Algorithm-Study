import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H;
    static int answer = -1;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];

        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[x][y+1] = -1;
        }

        for(int i = 0; i < 4; ++i)
        {
            dfs(0,i);
        }
        System.out.print(answer);
    }
    static void dfs(int cnt, int dest)
    {
        if(cnt == dest)
        {
            if(play())
            {
                System.out.print(dest);
                System.exit(0);
            }
            return;
        }

        for(int i = 1; i <= H; ++i) // 1 5
        {
            for(int j = 1; j < N; ++j)
            {
                if(map[i][j] != 0 || map[i][j+1] > 0) continue;
                map[i][j] = 1;
                map[i][j+1] = -1;
                dfs(cnt+1,dest);
                map[i][j] = 0;
                map[i][j+1] = 0;
            }
        }
    }
    static boolean play()
    {
        boolean res = true;
        for(int i = 1; i <= N; ++i)
        {
            int cur_x = 1;
            int cur_y = i;

            while(cur_x < H+1)
            {
                if(map[cur_x][cur_y] > 0)
                {
                    cur_y++;
                }
                else if(map[cur_x][cur_y] < 0)
                {
                    cur_y--;
                }
                cur_x++;
            }
            if(cur_y != i)
            {
                res = false;
                break;
            }
        }
        return res;
    }
}

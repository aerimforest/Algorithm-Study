import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Virus> virus;
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] selectVirus;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int result = Integer.MAX_VALUE;
    static boolean clear = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N][N];
        virus = new ArrayList<>();

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.valueOf(str.nextToken());
                if(num == 0 || num == 1) arr[i][j] = num;
                if(num == 2){
                    virus.add(new Virus(i,j));
                    arr[i][j] = 0;
                }
            }
        }

        selectVirus = new boolean[virus.size()];

        dfs(0, 0);

        if(clear) System.out.println(result);
        else System.out.println(-1);
    }

    private static void dfs(int depth, int index) {
        if(depth == M){
            checkVirus();
            return;
        }


        for(int i = index; i < virus.size(); i++){
            selectVirus[i] = true;
            dfs(depth + 1, i + 1);
            selectVirus[i] = false;
        }
    }

    private static void checkVirus() {
        boolean[][] check = new boolean[N][N];
        Queue<Virus> queue = new LinkedList<>();
        for(int i = 0; i < selectVirus.length; i++){
            if(!selectVirus[i]) continue;

            Virus target = virus.get(i);
            queue.add(target);
            check[target.x][target.y] = true;
        }

        int time = 0;
        while(!queue.isEmpty() && time < result){
            boolean addTime = false;
            int size = queue.size();
            for(int k = 0; k < size; k++){
                Virus virus = queue.poll();
                for(int i = 0 ; i < 4; i++){
                    int xx = virus.x + dx[i];
                    int yy = virus.y + dy[i];
                    if(xx < 0 || xx >= N || yy < 0 || yy >= N || check[xx][yy] || arr[xx][yy] == 1) continue;

                    check[xx][yy] = true;
                    queue.add(new Virus(xx,yy));
                    addTime = true;
                }
            }
            if(addTime) time++;
        }

        //전체 바이러스를 퍼뜨렸는지 체크
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check[i][j] && arr[i][j] == 0) return;
            }
        }

        clear = true;
        result = Math.min(result, time);
    }

    public static class Virus{
        int x;
        int y;
        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

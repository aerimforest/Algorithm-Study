import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static boolean[] check;
    static List<CCTV> cctv;
    static int[][] arr;
    static int N;
    static int M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int min;
    static int zeroCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N][M];
        min = N * M;
        cctv = new LinkedList<>();
        check = new boolean[cctv.size()];
        zeroCount = 0;

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                if(arr[i][j] > 0 && arr[i][j] < 6) cctv.add(new CCTV(i,j,arr[i][j]));
                if(arr[i][j] == 0) zeroCount++;
            }
        }

        dfs(0);
        System.out.println(min);
    }

    private static void dfs(int depth) {
        if(depth == cctv.size()){
            checkCCTV();
            return;
        }

        CCTV target = cctv.get(depth);

        switch (target.type){
            case 1:
            case 3:
            case 4:
                for(int i = 0; i < 4; i++){
                    target.direct(i);
                    dfs(depth + 1);
                }
                break;
            case 2:
                for(int i = 0; i < 2; i++){
                    target.direct(i);
                    dfs(depth + 1);
                }
                break;
            case 5:
                target.direct(0);
                dfs(depth + 1);
                break;

        }
    }

    private static void checkCCTV() {
        Set<CCTV> change = new HashSet<>();
        for(int i = 0; i < cctv.size(); i++){
            CCTV target = cctv.get(i);
            switch (target.type){
                case 1:
                    change.addAll(changeCCTV(target.x, target.y, target.direct));
                    break;

                case 2:
                    change.addAll(changeCCTV(target.x, target.y, target.direct));
                    change.addAll(changeCCTV(target.x, target.y, target.direct + 2));
                    break;

                case 3:
                    change.addAll(changeCCTV(target.x, target.y, target.direct));
                    change.addAll(changeCCTV(target.x, target.y, (target.direct + 1) % 4));
                    break;

                case 4:
                    change.addAll(changeCCTV(target.x, target.y, target.direct));
                    change.addAll(changeCCTV(target.x, target.y, (target.direct + 1) % 4));
                    change.addAll(changeCCTV(target.x, target.y, (target.direct + 2) % 4));
                    break;
                case 5:
                    change.addAll(changeCCTV(target.x, target.y, target.direct));
                    change.addAll(changeCCTV(target.x, target.y, (target.direct + 1) % 4));
                    change.addAll(changeCCTV(target.x, target.y, (target.direct + 2) % 4));
                    change.addAll(changeCCTV(target.x, target.y, (target.direct + 3) % 4));
                    break;
            }
        }

        min = Math.min(min, zeroCount - change.size());
    }

    private static Set<CCTV> changeCCTV(int x, int y, int direct) {
        List<CCTV> change = new ArrayList<>();
        change.add(new CCTV(x,y));

        for(int i = 0; i < change.size(); i++){
            CCTV target = change.get(i);
            int xx = target.x + dx[direct];
            int yy = target.y + dy[direct];

            if(xx < 0 || xx >= N || yy < 0 || yy >= M || arr[xx][yy] == 6) continue;
            change.add(new CCTV(xx,yy));
        }

        Set<CCTV> set = new HashSet<>();
        for(int i = 0; i < change.size(); i++){
            if(arr[change.get(i).x][change.get(i).y] == 0) set.add(change.get(i));
        }

        return set;
    }

    public static class CCTV {
        int x;
        int y;
        int type;
        int direct;
        public CCTV(int x, int y){
            this.x = x;
            this.y = y;
        }
        public CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public void direct(int direct){
            this.direct = direct;
        }

        public int hashCode(){
            return Objects.hash(x,y);
        }

        public boolean equals(Object o){
            if(o instanceof CCTV){
                CCTV tmp = (CCTV)o;
                return tmp.x == this.x && tmp.y == this.y;
            }
            return false;
        }
    }
}

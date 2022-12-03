import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static char[][] arr;
    static int num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        num = Integer.valueOf(str.nextToken());
        arr = new char[num][num];
        for(int i = 0; i < num; i++){
            String s = br.readLine();
            for(int j = 0; j < num; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        Log log = null;
        Log end = null;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(log == null && arr[i][j] == 'B'){
                    if(i + 1 < num && arr[i + 1][j] == 'B') log = new Log(i + 1, j, 0);
                    else log = new Log(i, j + 1, 1);
                }
                else if(end == null && arr[i][j] == 'E'){
                    if(i + 1 < num && arr[i + 1][j] == 'E') end = new Log(i + 1, j, 0);
                    else end = new Log(i, j + 1, 1);
                }
            }
        }
        System.out.println(bfs(log, end));
    }

    public static int bfs(Log log, Log end){
        //bfs
        Queue<Log> queue = new LinkedList<>();
        queue.add(log);
        int count = 0;
        boolean[][][] check = new boolean[num][num][2];
        check[log.x][log.y][log.horizontal] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Log target = queue.poll();
                if(target.checkSame(end)) return count;

                Log change;
                //turn
                change = target.turn();
                if(!check[change.x][change.y][change.horizontal]) {
                    queue.add(change);
                    check[change.x][change.y][change.horizontal] = true;
                }

                //상
                change = target.moveX(-1);
                if(!check[change.x][change.y][change.horizontal]) {
                    queue.add(change);
                    check[change.x][change.y][change.horizontal] = true;
                }

                //하
                change = target.moveX(1);
                if(!check[change.x][change.y][change.horizontal]) {
                    queue.add(change);
                    check[change.x][change.y][change.horizontal] = true;
                }

                //좌
                change = target.moveY(-1);
                if(!check[change.x][change.y][change.horizontal]) {
                    queue.add(change);
                    check[change.x][change.y][change.horizontal] = true;
                }

                //우
                change = target.moveY(1);
                if(!check[change.x][change.y][change.horizontal]) {
                    queue.add(change);
                    check[change.x][change.y][change.horizontal] = true;
                }
            }
            count++;
        }

        return 0;
    }
    public static class Log{
        int x;
        int y;
        int horizontal;
        public Log(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.horizontal = h;
        }

        public boolean checkSame(Log end){
            if(this.x == end.x && this.y == end.y && this.horizontal == end.horizontal)
                return true;

            return false;
        }

        public Log turn(){
            if(x > 0 && x < num - 1 && y > 0 && y < num - 1){
                for(int i = x - 1; i <= x + 1; i++){
                    for(int j = y - 1; j <= y + 1; j++){
                        if(arr[i][j] == '1') return this;
                    }
                }
                if(horizontal == 0)
                    return new Log(x,y,1);
                else
                    return new Log(x,y,0);
            }

            return this;
        }

        public Log moveX(int dx){
            int xx = x + dx;
            if(horizontal == 0){
                if(xx < 1 || xx >= num -1) return this;

                for(int i = xx - 1; i <= xx + 1; i++){
                    if(arr[i][y] == '1') return this;
                }
            }
            else{
                if(xx < 0 || xx >= num) return this;

                for(int i = y - 1; i <= y + 1; i++){
                    if(i == -1)
                        System.out.println(1);
                    if(arr[xx][i] == '1') return this;
                }
            }

            return new Log(xx, y, horizontal);
        }

        public Log moveY(int dy){
            int yy = y + dy;
            if(horizontal == 0){
                if(yy < 0 || yy >= num) return this;

                for(int i = x - 1; i <= x + 1; i++){
                    if(arr[i][yy] == '1') return this;
                }
            }
            else{
                if(yy < 1 || yy >= num - 1) return this;

                for(int i = yy - 1; i <= yy + 1; i++){
                    if(arr[x][i] == '1') return this;
                }
            }

            return new Log(x, y + dy, horizontal);
        }
    }
}

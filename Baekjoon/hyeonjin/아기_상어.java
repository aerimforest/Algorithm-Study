import java.io.*;
import java.util.*;

public class 아기_상어 {
    static int N;
    static int[][] arr;
    static Fish babyShark;
    static List<Fish> fish = new ArrayList<>();
    static int time = 0;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;
        N = Integer.valueOf(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
                if(arr[i][j] == 0) continue;

                if(arr[i][j] == 9) babyShark = new Fish(i,j,2);
                else fish.add(new Fish(i,j,arr[i][j]));
            }
        }
        arr[babyShark.x][babyShark.y] = 0;
        eatFish();

        bw.write(String.valueOf(time));
        bw.flush();
    }

    private static void eatFish() {
        while(true){
            //먹을 물고기를 찾음
            Fish eatFish = findEatFish();
            if(eatFish == null) break;

            //물고기 먹으러 이동
            moveEatFish(eatFish);
        }
    }

    private static void moveEatFish(Fish eat) {
        //이동
        time += eat.dist;
        arr[eat.x][eat.y] = 0;
        fish.remove(eat);
        babyShark.x = eat.x;
        babyShark.y = eat.y;

        //먹고 레벨 업
        babyShark.eat++;
        if(babyShark.eat == babyShark.size) {
            babyShark.size++;
            babyShark.eat = 0;
        }
    }

    private static Fish findEatFish() {
        Queue<Fish> queue = new LinkedList<>();
        queue.add(babyShark);
        boolean[][] check = new boolean[N][N];
        check[babyShark.x][babyShark.y] = true;

        PriorityQueue<Fish> findFish = new PriorityQueue<>();
        while(!queue.isEmpty() && findFish.size() == 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Fish target = queue.poll();

                for(int k = 0; k < 4; k++){
                    int x = target.x + dx[k];
                    int y = target.y + dy[k];

                    if(x < 0 || x >= N || y < 0 || y >= N || check[x][y] || arr[x][y] > babyShark.size) continue;

                    check[x][y] = true;
                    Fish f = new Fish(x,y,arr[x][y]);
                    f.dist = target.dist + 1;
                    queue.add(f);

                    if(arr[x][y] != 0 && arr[x][y] < babyShark.size) findFish.add(f);
                }
            }
        }

        if(findFish.size() == 0) return null;

        return findFish.peek();
    }

    public static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int size;
        int eat;
        int dist;
        public Fish(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Fish o){
            if(x != o.x) return x - o.x;
            return y - o.y;
        }
    }
}

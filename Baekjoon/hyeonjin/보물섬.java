import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final char LAND = 'L';
    static final char SEA = 'W';
    static char[][] arr;

    static int height;
    static int width;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        height = Integer.valueOf(str.nextToken());
        width = Integer.valueOf(str.nextToken());
        arr = new char[height][width];

        for(int i = 0; i < height; i++){
            String s = br.readLine();
            for(int j = 0; j < width; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(arr[i][j] == LAND)
                    bfs(i ,j);
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] check = new boolean[height][width];
        queue.add(new Node(x,y));
        check[x][y] = true;
        int time = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size; i++){
                Node node = queue.poll();
                for(int k = 0; k < 4; k++){
                    int xx = node.x + dx[k];
                    int yy = node.y + dy[k];

                    if(xx >= 0 && xx < height && yy >=0 && yy < width && !check[xx][yy] && arr[xx][yy] == LAND){
                        queue.add(new Node(xx,yy));
                        check[xx][yy] = true;
                    }
                }
            }
            time++;
        }

        max = Math.max(time - 1, max);
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

import java.io.*;
import java.util.*;

public class 연구소_3 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] checkArr;
    static List<Node> virus = new ArrayList<>();
    static List<Node> selectVirus = new ArrayList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int min = Integer.MAX_VALUE;
    static int emptyCount = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());

                if(arr[i][j] == 0) emptyCount++;
                else if(arr[i][j] == 2) virus.add(new Node(i,j));
            }
        }

        if(emptyCount == 0){
            System.out.println(0);
            return;
        }

        selectVirus(0,0);

        bw.write(min == Integer.MAX_VALUE ? "-1" : String.valueOf(min));
        bw.flush();
    }

    private static void selectVirus(int depth, int index) {
        if(depth == M){
            spreadVirus();
            return;
        }

        for(int i = index; i < virus.size(); i++){
            selectVirus.add(virus.get(i));
            selectVirus(depth + 1, i + 1);
            selectVirus.remove(depth);
        }
    }

    private static void spreadVirus() {
        checkArr = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();

        for(Node sv : selectVirus){
            queue.add(sv);
        }

        int cnt = 0;
        int spreadCount = 0;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();

                for(int k = 0; k < 4; k++){
                    int x = node.x + dx[k];
                    int y = node.y + dy[k];

                    if(x < 0 || x >= N || y < 0 || y >= N || arr[x][y] == 1 || checkArr[x][y]) continue;

                    if(arr[x][y] == 0) spreadCount++;
                    if(spreadCount == emptyCount) {
                        min = Math.min(cnt, min);
                        return;
                    }

                    queue.add(new Node(x,y));
                    checkArr[x][y] = true;
                }
            }
        }

    }

    private static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

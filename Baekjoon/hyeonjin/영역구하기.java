import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0 ,1};
    static int count = 0;
    static boolean[][] paper;
    static int height;
    static int width;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        height = Integer.valueOf(str.nextToken());
        width = Integer.valueOf(str.nextToken());
        int num = Integer.valueOf(str.nextToken());
        paper = new boolean[height][width];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i =0; i < num; i++){
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            for(int h = y1; h < y2; h++){
                for(int w = x1; w < x2; w++){
                    paper[h][w] = true;
                }
            }
        }

        for(int i =0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(!paper[i][j]) {
                    count = 0;
                    FindConnect(i, j);
                    priorityQueue.add(count);
                }
            }
        }

        int qSize = priorityQueue.size();
        bw.write(String.valueOf(qSize));
        bw.newLine();
        for(int i = 0; i < qSize; i++){
            bw.write(String.valueOf(priorityQueue.poll()));
            bw.write(" ");
        }


        bw.flush();
    }

    private static void FindConnect(int i, int j) {
        paper[i][j] = true;
        count++;

        for(int k = 0; k < 4; k++){
            int h = i + dx[k];
            int w = j + dy[k];
            if(w >= 0 && w < width && h >= 0 && h < height && !paper[h][w])
                FindConnect(h, w);
        }
    }
}

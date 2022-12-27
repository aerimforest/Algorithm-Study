import java.io.*;
import java.util.*;

public class Main {
    static int h;
    static int w;
    static char[][] arr;
    static Queue<Point> people;
    static Queue<Point> fire;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.valueOf(br.readLine());
        for(int t = 0; t < test_case; t++){
            inputData(br);

            boolean isEscape = false;
            if(!checkEscape(people.peek().x, people.peek().y)) {

                int count = 1;
                while (!isEscape && !people.isEmpty()) {
                    count++;
                    moveFire();
                    isEscape = movePeople();
                }

                if (isEscape) bw.write(String.valueOf(count));
                else bw.write("IMPOSSIBLE");
            }
            else bw.write("1");
            bw.newLine();
        }
        bw.flush();
    }

    private static void inputData(BufferedReader br) throws IOException {
        StringTokenizer str = new StringTokenizer(br.readLine());
        w = Integer.valueOf(str.nextToken());
        h = Integer.valueOf(str.nextToken());

        arr = new char[h][w];
        people = new LinkedList<>();
        fire = new LinkedList<>();

        for(int i = 0; i < h; i++){
            String s = br.readLine();
            for(int j = 0; j < w; j++){
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == '@') people.add(new Point(i,j));
                else if(arr[i][j] == '*') fire.add(new Point(i,j));
            }
        }
    }
    private static void moveFire() {
        int size = fire.size();
        for(int i = 0; i < size; i++){
            Point p = fire.poll();
            for(int k = 0; k < 4; k++){
                int x = p.x + dx[k];
                int y = p.y + dy[k];

                if(x < 0 || x >= h || y < 0 || y >= w || arr[x][y] == '#' || arr[x][y] == '*') continue;

                fire.add(new Point(x,y));
                arr[x][y] = '*';
            }
        }
    }

    private static boolean movePeople() {
        int size = people.size();

        for(int i = 0; i < size; i++){
            Point p = people.poll();

            for(int k = 0; k < 4; k++){
                int x = p.x + dx[k];
                int y = p.y + dy[k];

                if(x < 0 || x >= h || y < 0 || y >= w || arr[x][y] != '.') continue;

                if(checkEscape(x,y)) return true;

                people.add(new Point(x,y));
                arr[x][y] = '@';
            }
        }
        return false;
    }

    private static boolean checkEscape(int x, int y) {
        if(x == 0 || x == h - 1 || y == 0 || y == w - 1) return true;
        return false;
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

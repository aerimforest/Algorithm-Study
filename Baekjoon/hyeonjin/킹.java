import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 킹 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        String kingStr = str.nextToken();
        String stoneStr = str.nextToken();
        int N = Integer.valueOf(str.nextToken());

        Horse king = findPosition(kingStr);
        Horse stone = findPosition(stoneStr);

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            int dx = 0;
            int dy = 0;

            if(s.contains("R")) dy = 1;
            else if(s.contains("L")) dy = -1;

            if(s.contains("B")) dx = -1;
            else if(s.contains("T")) dx = 1;

            int kx = king.x + dx;
            int ky = king.y + dy;
            if(kx < 0 || kx >= 8 || ky < 0 || ky >= 8) continue;

            //돌이 있으면 돌을 움직일 수 있는지 체크 해야함
            if(stone.x == kx && stone.y == ky){
                int sx = stone.x + dx;
                int sy = stone.y + dy;

                if(sx < 0 || sx >= 8 || sy < 0 || sy >= 8) continue;

                stone = new Horse(sx, sy);
            }
            king = new Horse(kx, ky);
        }

        bw.write(rollBack(king));
        bw.newLine();
        bw.write(rollBack(stone));
        bw.flush();
        bw.close();
    }

    private static String rollBack(Horse horse){
        String s = "";
        s += (char)(horse.y + 'A');
        s += (char)(horse.x + '1');

        return s;
    }

    private static Horse findPosition(String target) {
        int y = target.charAt(0) - 'A';
        int x = target.charAt(1) - '1';
        return new Horse(x,y);
    }

    public static class Horse{
        int x;
        int y;
        public Horse(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

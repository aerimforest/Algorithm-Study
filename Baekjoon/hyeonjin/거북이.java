import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.valueOf(br.readLine());

        for(int i = 0; i < num; i++){
            int x = 0;
            int y = 0;
            int direct = 0;

            int maxX = 0;
            int minX = 0;
            int maxY = 0;
            int minY = 0;

            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                switch (str.charAt(j)){
                    case 'F':
                        x += dx[direct];
                        y += dy[direct];
                        break;
                    case 'B':
                        x += dx[(direct + 2) % 4];
                        y += dy[(direct + 2) % 4];
                        break;
                    case 'L':
                        direct--;
                        if(direct < 0)
                            direct += 4;
                        break;
                    case 'R':
                        direct++;
                        direct %= 4;
                        break;
                }

                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
            }

            bw.write(String.valueOf(Math.abs(maxX - minX) * Math.abs(maxY - minY)));
            bw.newLine();
        }
        bw.flush();
    }
}

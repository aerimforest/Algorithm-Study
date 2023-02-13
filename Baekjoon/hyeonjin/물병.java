import java.io.*;
import java.util.StringTokenizer;

public class 물병 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int waterCount = Integer.valueOf(str.nextToken());
        int moveCount = Integer.valueOf(str.nextToken());

        int plus = 0;
        while(true){
            int tmp = waterCount + plus;
            int count = 0;

            while(tmp > 0){
                if(tmp % 2 != 0) count++;
                tmp /= 2;
            }

            if(count <= moveCount)
                break;

            plus++;
        }
        bw.write(String.valueOf(plus));
        bw.flush();
    }
}

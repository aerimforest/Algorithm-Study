import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int x = Integer.valueOf(str.nextToken());
        int y = Integer.valueOf(str.nextToken());
        int block = Integer.valueOf(str.nextToken());
        int[][] ground = new int[x][y];

        for(int i =0; i < x; i++){
            str = new StringTokenizer(br.readLine());
            for(int j =0; j < y; j++){
                ground[i][j] = Integer.valueOf(str.nextToken());
            }
        }


        int minTime = Integer.MAX_VALUE;
        int selectHeight = 0;
        for(int height = 0; height <= 256; height++){
            int time = 0;
            int copyBlock = block;
            //땅 고르게 만들기
            for(int i =0 ; i < x; i++){
                for(int j = 0; j < y; j++){
                    int heightDiff = ground[i][j] - height;
                    if(heightDiff > 0)
                    {
                        copyBlock += heightDiff;
                        time += 2 * heightDiff;
                    }
                    else if(heightDiff < 0){
                        copyBlock += heightDiff;
                        time -= heightDiff;
                    }
                }
            }
            //기존 것과 비교
            if(copyBlock < 0)
                continue;

            if(time <= minTime){
                selectHeight = height;
                minTime = time;
            }
        }
        String result = minTime + " " + selectHeight;
        bw.write(result);
        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] curTowerHeights;
    static int[] signal;
    static Stack<Tower> stack;

    static class Tower{
        int index;
        int height;

        public Tower(int index, int height){
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        topHeights = new int[N];
        signal = new int[N+1];
        curTowerHeights = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            curTowerHeights[i] = Integer.parseInt(st.nextToken());
        }// end input
        Tower firstTower = new Tower(0, 0);
        stack.push(firstTower);
        Tower heightestTower = firstTower;
        for(int i = 1; i <= N; i++){
            if(curTowerHeights[i-1] - curTowerHeights[i] > 0){
                //현재타워가 이전 타워보다 작은 경우
                stack.push(heightestTower);
                heightestTower = new Tower(i-1, curTowerHeights[i-1]);
            }else if(curTowerHeights[i] - curTowerHeights[i-1] > 0
                    && curTowerHeights[i] - heightestTower.height > 0){
                //현재타워가 이전 타워보다 큰 경우 && 신호 받는 타워보다 큰 경우
                heightestTower = stack.pop();
                while(true){
                    if(heightestTower == firstTower){
                        stack.push(firstTower);
                        break;
                    }
                    if(heightestTower.height - curTowerHeights[i] >= 0){
                        //신호를 받는 타워를 찾으면
                        break;
                    }
                    heightestTower = stack.pop();
                }
            }
            signal[i] = heightestTower.index;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(signal[i]).append(" ");
        }
        System.out.println(sb);
    }
}

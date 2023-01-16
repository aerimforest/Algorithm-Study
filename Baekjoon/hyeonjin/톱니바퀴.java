import java.io.*;
import java.util.*;

public class 톱니바퀴 {
    static int[][] gear;
    static int[] topIndex;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        gear = new int[5][8];
        topIndex = new int[5];
        for(int i = 1; i <= 4; i++){
            String s = br.readLine();
            for(int j = 0; j < 8; j++){
                gear[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int K = Integer.valueOf(br.readLine());
        for(int i = 0; i < K; i++){
            str = new StringTokenizer(br.readLine());
            rotate(new Rotate(Integer.valueOf(str.nextToken()), Integer.valueOf(str.nextToken())));
        }

        countScore();
    }

    private static void countScore() {
        int result = 0;
        if(gear[1][topIndex[1]] == 1) result += 1;
        if(gear[2][topIndex[2]] == 1) result += 2;
        if(gear[3][topIndex[3]] == 1) result += 4;
        if(gear[4][topIndex[4]] == 1) result += 8;

        System.out.println(result);
    }

    public static void rotate(Rotate rotate){
        boolean[] check = new boolean[5];
        Queue<Rotate> queue = new LinkedList<>();
        queue.add(rotate);
        check[rotate.index] = true;
        List<Rotate> changeList = new ArrayList<>();

        while(!queue.isEmpty()){
            Rotate target = queue.poll();
            changeList.add(target);

            int now = target.index;
            int left = target.index - 1;
            int right = target.index + 1;

            //왼쪽 체크
            if(left > 0 && !check[left]){
                int leftPole = gear[left][(topIndex[left] + 2) % 8];
                int rightPole = gear[now][(topIndex[now] + 6) % 8];

                if(leftPole != rightPole) {
                    check[left] = true;
                    queue.add(new Rotate(left, target.direct * -1));
                }
            }

            //오른쪽 체크
            if(right <= 4 && !check[right]){
                int leftPole = gear[now][(topIndex[now] + 2) % 8];
                int rightPole = gear[right][(topIndex[right] + 6) % 8];

                if(leftPole != rightPole) {
                    check[right] = true;
                    queue.add(new Rotate(right, target.direct * -1));
                }
            }
        }

        changeGear(changeList);
    }

    private static void changeGear(List<Rotate> changeList) {
        for(Rotate rotate : changeList){
            topIndex[rotate.index] -= rotate.direct;
            if(topIndex[rotate.index] < 0) topIndex[rotate.index] += 8;
            else if(topIndex[rotate.index] >= 8) topIndex[rotate.index] -= 8;
        }
    }

    public static class Rotate{
        int index;
        int direct;

        public Rotate(int index, int direct){
            this.index = index;
            this.direct = direct;
        }
    }
}

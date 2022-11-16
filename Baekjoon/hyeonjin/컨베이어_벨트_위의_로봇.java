import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main{
    static int length;
    static int zeroCount;
    static int[] conveyor;
    static int upPosition;
    static int downPosition;
    static List<Integer> robot;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        length = Integer.valueOf(str.nextToken());
        zeroCount = Integer.valueOf(str.nextToken());
        conveyor = new int[2 * length + 1];
        robot = new ArrayList<>();
        upPosition = 1;
        downPosition = length;
        int stage = 0;

        str = new StringTokenizer(br.readLine());
        for(int i =1 ; i <= 2 * length; i++){
            conveyor[i] = Integer.valueOf(str.nextToken());
        }

        while(true){
            stage++;
            rotationBelt();
            moveRobot();
            uPRobot();
            if(CountZero() >= zeroCount)
                break;
        }
        bw.write(String.valueOf(stage));
        bw.flush();
    }

    private static int CountZero() {
        int count = 0;
        for(int i = 1; i <= 2 * length; i++){
            if(conveyor[i] == 0)
                count++;
        }
        return count;
    }

    private static void uPRobot() {
        if(conveyor[upPosition] > 0)
        {
            robot.add(upPosition);
            conveyor[upPosition]--;
        }
    }

    private static void downRobot(){
        for(int num : robot){
            if(num == downPosition){
                robot.remove(Integer.valueOf(num));
                return;
            }
        }
    }

    private static void moveRobot() {
        for(int index : robot){
            int nextIndex = index + 1 > 2 * length ? 1 : index + 1;
            if(!robot.contains(nextIndex) && conveyor[nextIndex] > 0){
                robot.set(robot.indexOf(index), nextIndex);
                conveyor[nextIndex]--;
            }
        }
        downRobot();
    }

    private static void rotationBelt() {
        upPosition--;
        downPosition--;

        if(upPosition == 0)
            upPosition = 2 * length;

        if(downPosition == 0)
            downPosition = 2 * length;

        downRobot();
    }
}

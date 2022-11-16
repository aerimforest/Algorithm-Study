import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] people;
    static int peopleNum;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        peopleNum = Integer.valueOf(str.nextToken());
        int animalNum = Integer.valueOf(str.nextToken());
        int distance = Integer.valueOf(str.nextToken());
        people = new int[peopleNum];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < peopleNum; i++){
            people[i] = Integer.valueOf(str.nextToken());
        }

        Arrays.sort(people);
        for(int i = 0; i < animalNum; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            if(y > distance)
                continue;

            int xAxis = distance - y;
            binarySearch(0,peopleNum,x - xAxis, x + xAxis);
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void binarySearch(int left, int right, int min, int max) {
        int index = (left + right) / 2;

        if(people[index] >= min && people[index] <= max){
            count++;
            return;
        }
        if(index == left || index == right)
            return;

        if(people[index] < min)
            binarySearch(index + 1, right, min, max);
        else if(people[index] > max)
            binarySearch(left, index, min, max);
    }
}

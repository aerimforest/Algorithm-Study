import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int num;
    static int[] visible;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        num = Integer.valueOf(str.nextToken());
        arr = new int[num];
        visible = new int[num];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        check();
        int max = 0;
        for(int i =0 ; i < visible.length; i++){
            max = Math.max(visible[i], max);
        }
        System.out.println(max);

    }

    private static void check() {
        for(int i = 0; i < num - 1; i++){
            visible[i] += 1;
            visible[i+1] += 1;

            double compare = arr[i + 1] - arr[i];

            for(int j = i + 2; j < num; j++){
                double nextCompare = (double)(arr[j] - arr[i]) / (j - i);
                if(nextCompare <= compare) continue;

                compare = nextCompare;
                visible[i]++;
                visible[j]++;
            }
        }
    }
}

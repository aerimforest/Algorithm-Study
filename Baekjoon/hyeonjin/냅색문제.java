import java.io.*;
import java.util.*;

public class 냅색문제 {
    static int N;
    static int C;
    static int[] arr;
    static List<Integer> leftSum;
    static List<Integer> rightSum;
    static int index;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        C = Integer.valueOf(str.nextToken());

        leftSum = new ArrayList<>();
        rightSum = new ArrayList<>();

        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(str.nextToken());
        }

        dfs(0,0,leftSum, N / 2);
        dfs(N / 2, 0, rightSum, N);
        Collections.sort(rightSum);

        int result = 0;
        for(int i = 0; i < leftSum.size(); i++){
            index = -1;
            binarySearch(0, rightSum.size() - 1, C - leftSum.get(i));
            result += index + 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void binarySearch(int start, int end, int value) {
        if(start > end) return;

        int mid = (start + end) / 2;

        if(rightSum.get(mid) <= value){
            index = mid;
            binarySearch(mid + 1, end, value);
            return;
        }

        binarySearch(start, mid - 1, value);
    }

    public static void dfs(int depth, int sum, List<Integer> sumList, int maxIndex){
        if(sum > C) return;

        if(depth == maxIndex) {
            sumList.add(sum);
            return;
        }

        dfs(depth + 1, sum + arr[depth], sumList, maxIndex);
        dfs(depth + 1, sum, sumList, maxIndex);
    }
}

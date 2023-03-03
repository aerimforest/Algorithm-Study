import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) stack.pop();
            result[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(A[i]);
        }

        System.out.println(Arrays.stream(result)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
        br.close();
    }
}

import java.util.*;
import java.io.*;

public class Main {

    public static int N,L,count,tape;
    public static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        tape = (int)(arr[0] - 0.5 + L);
		count ++;


		for(int i=1; i<N; i++) {
			if (tape < (int)(arr[i] + 0.5)){
				tape = (int)(arr[i] - 0.5 + L);
				count ++;
			}
		}

		System.out.println(count);
    }
}

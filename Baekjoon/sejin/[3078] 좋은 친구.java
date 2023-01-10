import java.io.*;
import java.util.*;
       
public class Main {

	static int N, K;
	static long result = 0;
	static int[] list;
	static char[] temp;
	static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new int[N];

        for(int i=0;i<N;i++) list[i] = br.readLine().length();

        // 1등에 해당하는 좋은 친구 구하기 
        for(int i=0;i<=K;i++) add(i);

        int l = 0, r = K+1;
        while(l<N){
            if(hm.get(list[l]) > 1) result += hm.get(list[l])-1;
            if(r < N) add(r++);
            hm.put(list[l], hm.get(list[l])-1);
            l += 1;
        }

        System.out.println(result);

	}

    public static void add(int idx){
        if(hm.containsKey(list[idx])) hm.put(list[idx],hm.get(list[idx])+1);
        else hm.put(list[idx],1);
    }
    

}

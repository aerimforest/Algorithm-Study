import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        List<Integer> crane = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            crane.add(Integer.valueOf(str.nextToken()));
        }

        str = new StringTokenizer(br.readLine());
        int M = Integer.valueOf(str.nextToken());
        List<Integer> box = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            box.add(Integer.valueOf(str.nextToken()));
        }

        box.sort(Comparator.reverseOrder());
        crane.sort(Comparator.reverseOrder());

        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!box.isEmpty()){
            time++;
            for(int c : crane){
                for(int i =0 ; i < box.size(); i++){
                    if(c >= box.get(i)){
                        box.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.println(time);
    }
}

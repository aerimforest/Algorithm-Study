import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.println(1);
            return;
        }

        StringTokenizer s = new StringTokenizer(br.readLine());
        ArrayList<Integer> ranklist = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ranklist.add(Integer.parseInt(s.nextToken()));
        }

        int rank = 1;
        if(ranklist.size() == p && point <= ranklist.get(ranklist.size()-1)) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(point >= ranklist.get(i)) {
                rank = i + 1;
                break;
            }else {
                rank++;
            }
        }

        if(rank <= p) {
            System.out.println(rank);
        }else {
            System.out.println(-1);
        }
    }
}

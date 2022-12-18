import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.valueOf(br.readLine());
        int student = Integer.valueOf(br.readLine());
        List<People> people = new ArrayList<>();

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < student; i++){
            int num = Integer.valueOf(str.nextToken());

            //존재하는지 체크
            boolean exsit = false;
            for(People p : people){
                if(p.num == num){
                    p.recommend++;
                    exsit = true;
                    Collections.sort(people);
                    break;
                }
            }
            if(exsit) continue;


            people.add(new People(1, num, i));
            //없으면 가장 작은 값 제외하고 새로 추가
            if(N < people.size()) people.remove(0);

            Collections.sort(people);
        }

        String result = "";
        for(int i = 1; i <= 100; i++){
            for(int j = 0; j < people.size(); j++){
                if(people.get(j).num == i) result += people.get(j).num + " ";
            }
        }

        System.out.println(result);
    }

    public static class People implements Comparable<People>{
        int recommend;
        int num;
        int order;

        public People(int r, int n, int o){
            this.recommend = r;
            this.num = n;
            this.order = o;
        }

        @Override
        public int compareTo(People p) {
            if(p.recommend == recommend)
                return order - p.order;

            return recommend - p.recommend;
        }
    }
}

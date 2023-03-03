import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            truck.add(Integer.parseInt(st.nextToken()));

        int t = 1, sum = 0, tmp = -1;
        List<Truck> bridge = new ArrayList<>();
        tmp = truck.poll();
        bridge.add(new Truck(tmp, w));
        sum = tmp;
        tmp = -1;

        while (true) {
            int cnt = 0;

            for (int i = 0; i < bridge.size(); i++) {
                bridge.get(i).time--;
                if (bridge.get(i).time == 0)
                    sum -= bridge.get(i).weight;
                if (bridge.get(i).time <= 0)
                    cnt++;
            }
            
            t++;

            if (cnt == n) break;

            if (tmp == -1 && !truck.isEmpty())
                tmp = truck.poll();

            if (tmp > -1 && sum + tmp <= l) {
                bridge.add(new Truck(tmp, w));
                sum += tmp;
                tmp = -1;
            }
        }

        System.out.println(t);
        bw.flush(); bw.close(); br.close();
    }

    static class Truck {
        int weight, time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}

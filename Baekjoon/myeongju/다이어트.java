import java.util.*;
import java.io.*;

/*
최소 영양분을 만족하면서 비용이 최소가 되도록
 */
public class Main {
    static int N;
    static Food min; //최소 영양성분
    static Food[] foods; // 음식목록
    static boolean[] v; // 선택여부
    static int ans = Integer.MAX_VALUE; // 최소비용
    static ArrayList<String> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        foods = new Food[N + 1];
        v = new boolean[N + 1];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = new Food(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i] = new Food(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }

        func(1, 0);
        if(ans==Integer.MAX_VALUE) System.out.print(-1);
        else {
            Collections.sort(list);
            System.out.println(ans);
            System.out.print(list.get(0));
        }
    }

    public static void func(int n, int price) {

        if (n == N + 1) {
            if (ans < price) return; // 지금까지 최소비용보다 비싸면 리턴
            Food now = new Food();
            for (int i = 1; i <= N; i++) {
                if (v[i]) add(now, foods[i]);
            } // 영양성분 만족하면 갱신
            if (min.f <= now.f && min.p <= now.p && min.v <= now.v && min.s <= now.s) {
                if (ans > price) {
                    ans = price;
                    list.clear();
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= N; i++) {
                    if (v[i]) sb.append(i + " ");
                }
                list.add(sb.toString());
            }
            return;
        }

        func(n + 1, price);
        v[n] = true;
        func(n + 1, price + foods[n].price);
        v[n] = false;
    }

    public static void add(Food f1, Food f2) {
        f1.f += f2.f;
        f1.p += f2.p;
        f1.s += f2.s;
        f1.v += f2.v;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static class Food {
        int p;
        int f;
        int s;
        int v;
        int price;

        public Food() {}

        public Food(int p, int f, int s, int v, int price) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.price = price;
        }
    }
}
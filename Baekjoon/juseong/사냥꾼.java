import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> hunters;
    static ArrayList<Animal> animals;
    static int m, n, l, ans;

    static void input() throws IOException {
        hunters = new ArrayList<>();
        animals = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) hunters.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            animals.add(new Animal(a, b));
        }
    }

    static class Animal{
        int x, y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean hunting(Animal animal) {
        int L = 0, R = hunters.size() - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            int x = hunters.get(mid);
            if(Math.abs(x-animal.x) + animal.y <= l) {
                return true;
            } else if(x < animal.x) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    static void pro() {
        Collections.sort(hunters);
        for (Animal animal: animals) {
            if (hunting(animal)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

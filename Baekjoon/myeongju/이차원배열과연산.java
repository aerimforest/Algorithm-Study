import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[100][100];
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        int t;
        x = 3;
        y = 3;

        for (int i = 0; i < 20; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (t = 0; t <= 100; ++t) {
            if (map[r][c] == k) {
                break;
            }

            if (x >= y) {
                R();
            } else {
                C();
            }
        }

        System.out.println(t > 100 ? -1 : t);
    }

    static void R() {
        int max = 0;
        for (int i = 0; i < x; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            ArrayList<num> al = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == -1) break;
                if (map[i][j] == 0) continue;
                hm.put(map[i][j], hm.getOrDefault(map[i][j], 0) + 1);
            }

            if (max < hm.size() * 2) {
                max = hm.size() * 2;
            }

            for (int k : hm.keySet()) {
                al.add(new num(k, hm.get(k)));
            }

            Collections.sort(al);


            for (int j = 0; j < 100; j += 2) {
                if (j / 2 < al.size()) {
                    map[i][j] = al.get(j / 2).ind;
                    map[i][j + 1] = al.get(j / 2).count;
                } else {
                    map[i][j] = -1;
                    map[i][j + 1] = -1;
                }
            }
        }
        if (y < max) {
            y = max;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == -1) map[i][j] = 0;
            }
        }
    }

    static void C() {
        int max = 0;

        for (int i = 0; i < y; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            ArrayList<num> al = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                if (map[j][i] == -1) break;
                if (map[j][i] == 0) continue;
                hm.put(map[j][i], hm.getOrDefault(map[j][i], 0) + 1);
            }

            if (max < hm.size() * 2) {
                max = hm.size() * 2;
            }

            for (int k : hm.keySet()) {
                al.add(new num(k, hm.get(k)));
            }

            Collections.sort(al);
            for (int j = 0; j < 100; j += 2) {
                if (j / 2 < al.size()) {
                    map[j][i] = al.get(j / 2).ind;
                    map[j + 1][i] = al.get(j / 2).count;
                } else {
                    map[j][i] = -1;
                    map[j + 1][i] = -1;
                }
            }
        }

        if (x < max) {
            x = max;
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[j][i] == -1) map[j][i] = 0;
            }
        }
    }

    static class num implements Comparable<num> {
        int ind;
        int count;

        num(int ind, int count) {
            this.ind = ind;
            this.count = count;
        }

        @Override
        public int compareTo(num o) {
            if (this.count == o.count) {
                return this.ind - o.ind;
            } else {
                return this.count - o.count;
            }
        }
    }
}
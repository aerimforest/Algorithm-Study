package baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DrinkBeer {

    /**
     * 백준(9205) - 맥주 마시면서 걸어가기(https://www.acmicpc.net/problem/9205)
     */
    private static List<Location> locations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            Location[] location = new Location[N + 2];
            int[] check = new int[N + 2];
            Queue<Location> q = new LinkedList<Location>();
            boolean success = false;
            String[] str;
            for (int i = 0; i < N + 2; i++) {
                str = reader.readLine().split(" ");
                location[i] = new Location(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            Location start = location[0];    //시작 위치
            Location end = location[N + 1];    //도착 위치
            q.add(start);    //시작 위치로 부터 출발

            while (!q.isEmpty()) {
                Location current = q.poll();
                if (current.equals(end)) {
                    success = true;
                    break;
                }
                for (int i = 1; i < N + 2; i++) {
                    if (check[i] == 0
                        && Math.abs(current.x - location[i].x) + Math.abs(current.y - location[i].y) <= 1000) {
                        q.add(location[i]);
                        check[i] = 1;
                    }
                }
            }
            if (success) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
        System.out.println();
    }

    static class Location {

        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

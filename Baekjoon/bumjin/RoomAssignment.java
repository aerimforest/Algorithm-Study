package Baekjoon.bumjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class RoomAssignment {

    /**
     * 백준(1931) - 회의실 배정(https://www.acmicpc.net/problem/1931)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        //시작시간, 종료시간
        int[][] arr = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    //종료시간 같으면 시작시간 기준으로 정렬
                    return o1[0] - o2[0];
                }
                //종료시간 기준으로 정렬
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time <= arr[i][0]) {
                //이전 종료 시간이 시작 시간보다 이전일때 갱신
                time = arr[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}

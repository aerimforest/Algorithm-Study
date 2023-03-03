package Baekjoon.seongkil;
import java.util.Scanner;

public class B24553_팰리드롬게임 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 케이스 수
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong(); // 돌 무더기의 크기

            // 돌 무더기의 크기가 홀수면 상윤이가 승리
            if (n % 10 == 0) {
                System.out.println(1);
            }
            // 돌 무더기의 크기가 짝수면 승우가 승리
            else {
                System.out.println(0);
            }
        }

        sc.close();
    }
}
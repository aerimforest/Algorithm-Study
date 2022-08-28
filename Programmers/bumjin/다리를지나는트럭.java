package Programmers.bumjin;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //모든 트럭이 건너려면 최소 몇 초

        //대기트럭
        Queue<Truck> wait = new LinkedList();
        //지나가는 트럭
        List<Truck> list = new ArrayList();

        for (int i : truck_weights) {
            wait.add(new Truck(i, bridge_length));
        }

        int currentWeight = 0;
        int possibleWeight = weight;

        while (!(wait.isEmpty() && list.isEmpty())) {
            if (!list.isEmpty() && list.get(0).distance <= 0) {
                //다리 위에서 제거
                possibleWeight += list.get(0).weight;//다리 무게 원상복귀
                list.remove(0);
            }

            if (!wait.isEmpty() && possibleWeight - wait.peek().weight >= 0) {
                possibleWeight -= wait.peek().weight;
                list.add(wait.poll());
            }

            for (int i=0; i<list.size(); i++) {
                Truck truck = list.get(i);
                truck.distance--;
            }
            answer++;
        }

        return answer;
    }

    static class Truck {
        int weight, distance;

        Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
}

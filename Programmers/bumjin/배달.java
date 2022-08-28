package Programmers.bumjin;

import java.util.*;

class Solution {
    private static final int INF = (int)1e9;
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] d;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //1 ~ N
        //양방향
        //최소배달시간
        //K시간 이하

        //index 1번부터
        d = new int[N + 1];

        graph = new ArrayList();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList());
        }

        for (int i=0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int dist = road[i][2];

            graph.get(start).add(new Node(end, dist));
            graph.get(end).add(new Node(start, dist));
        }

        //무한대로 채우기
        Arrays.fill(d, INF);

        //다익스트라 시작
        dijkstra();

        for (int i=1; i<d.length; i++) {
            if (d[i] <= K) {
                answer++;
            }
            System.out.println(d[i]);
        }

        return answer;
    }

    void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue();
        //시작 노드
        pq.add(new Node(1, 0));
        //시작 노드는 거리 0
        d[1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int dist = node.distance;

            //이미 가까워서 비교할 이유 없음
            if (d[index] < dist) {
                continue;
            }

            for (int i=0; i<graph.get(index).size(); i++) {
                //index까지의 거리 + index부터 다른 노드까지의 거리
                int cost = d[index] + graph.get(index).get(i).distance;

                //위에서 더한 값이 현재 걸리는 거리보다 작다면 갱신!
                if (cost < d[graph.get(index).get(i).index]) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.offer(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    static class Node {
        int index;
        int distance;

        Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

    }
}

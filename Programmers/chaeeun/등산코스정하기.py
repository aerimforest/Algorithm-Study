# [참고]

from collections import defaultdict
from heapq import heappop, heappush


# n: 노드 수
# gates: 출입구, sumits: 산봉우리
def solution(n, paths, gates, summits):
    def get_min_intensity():
        pq = []  # (intensity, 현재 위치)
        visited = [10000001] * (n + 1)

        # 모든 출발지를 우선순위 큐에 삽입
        for gate in gates:
            heappush(pq, (0, gate))
            visited[gate] = 0

        # 산봉우리에 도착할 때까지 반복
        while pq:
            intensity, node = heappop(pq)

            # 산봉우리를 만나면 종료
            if node in summits_set:
                return [node, intensity]

            # 이번 위치에서 이동할 수 있는 곳으로 이동
            for weight, next_node in graph[node]:
                # next_node 위치에 더 작은 intensity로 도착할 수 있다면 큐에 넣지 않음
                # (출입구는 이미 0으로 세팅되어있기 때문에 방문하지 않음)
                new_intensity = max(intensity, weight)
                if new_intensity < visited[next_node]:
                    visited[next_node] = new_intensity
                    heappush(pq, (new_intensity, next_node))

        return [-1, -1]

    summits.sort()
    summits_set = set(summits)
    # graph: 등산로 정보
    graph = defaultdict(list)
    for i, j, w in paths:
        graph[i].append((w, j))
        graph[j].append((w, i))

    return get_min_intensity()
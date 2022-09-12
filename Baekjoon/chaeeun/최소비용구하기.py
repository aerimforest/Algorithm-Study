import sys
from heapq import heappush, heappop

### 입력-1. 도시수, 버스수
N = int(input())  # 도시의 개수
M = int(input())  # 버스의 개수

### 입력-2. start, end, cost
bus = [[] for _ in range(N + 1)]
for _ in range(M):
    start, end, cost = map(int, input().split())  # 출발지, 도착지, 비용
    bus[start].append((end, cost))

### 입력-3. 출발지, 도착지
start, end = map(int, input().split())  # 찾고자하는 비용 경로(출발지, 도착지)

### 다익스트라 알고리즘
def dijkstra(start, end):
    heap = []
    heappush(heap, (0, start))  # 시작지점 힙에 추가
    distance = [sys.maxsize] * (N + 1)  # 각 정점사이의 거리 무한대로 초기화
    distance[start] = 0  # 시작 지점 0으로 초기화

    while heap:
        weight, index = heappop(heap)
        for e, c in bus[index]:
            if distance[e] > weight + c:
                distance[e] = weight + c
                heappush(heap, (weight + c, e))
    return distance[end]

### 출력
print(dijkstra(start, end))
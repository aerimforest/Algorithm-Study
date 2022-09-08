from collections import deque
import sys
input = lambda : sys.stdin.readline().strip()


def bfs():
    q = deque([home])
    while q:
        x, y = q.popleft()
        # 종료 조건
        if abs(x - fest[0]) + abs(y - fest[1]) <= 1000:
            print("happy")
            return

        for i in range(n):
            if not visited[i]:
                nx, ny = cs[i]
                if abs(x - nx) + abs(y - ny) <= 1000:
                    q.append([nx, ny])
                    visited[i] = 1
    print("sad")


t = int(input())
for _ in range(t):
    cs = []
    n = int(input())
    home = list(map(int, input().split()))
    for i in range(n):
        cs.append(list(map(int, input().split())))
    fest = list(map(int, input().split()))
    visited = [0 for _ in range(n+1)]
    bfs()

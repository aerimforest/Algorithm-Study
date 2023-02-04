from collections import deque
import sys
input = sys.stdin.readline


# 방향 대로 인덱스 접근
dx = [0,1,1,1,0,-1,-1,-1]
dy = [-1,-1,0,1,1,1,0,-1]

"""
7 0 1
6 - 2
5 4 3
"""

def bfs(queue: deque):
    while queue:
        r,c,m,s,d = queue.popleft()
        
        for _ in range(s):
            x = c + dx[d]
            y = r + dy[d]

            if x < 0 or y < 0 or x >= N or y >= N:
                continue
            

N,M,K = map(int,input().split())
graph = [[0]*N for _ in range(N)]
fire_ball = deque()
for _ in range(M):
    r,c,m,s,d = map(int,input().split())
    fire_ball.append([r,c,m,s,d])
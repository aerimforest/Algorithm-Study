from collections import deque
import sys

input = sys.stdin.readline


def bfs():
    while q or w:
        temp1 = []
        temp2 = []
        while q:
            a, b = q.popleft()
            if s[a][b] != "*":
                for i in range(4):
                    x = a + dx[i]
                    y = b + dy[i]
                    if 0 <= x < r and 0 <= y < c and visit[x][y] == 0 and s[x][y] != "X" and s[x][y] != "*":
                        s[x][y] = s[a][b] + 1
                        visit[x][y] = 1
                        temp1.append([x, y])
        while w:
            a, b = w.popleft()
            for i in range(4):
                x = a + dx[i]
                y = b + dy[i]
                if x == d[0] and y == d[1]:
                    continue
                if 0 <= x < r and 0 <= y < c and s[x][y] != "*" and s[x][y] != "X":
                    s[x][y] = "*"
                    temp2.append([x, y])
        for i in temp1:
            q.append(i)
        for i in temp2:
            w.append(i)


if __name__ == "__main__":
    dx = [1, -1, 0, 0]
    dy = [0, 0, -1, 1]
    r, c = map(int, input().split())
    s = []
    w = deque()
    q = deque()
    visit = [[0] * c for i in range(r)]

    for i in range(r):
        a = list(input().strip())
        s.append(a)
        for j in range(c):
            if a[j] == "D":
                d = [i, j]
            elif a[j] == "S":
                q.append([i, j])
                visit[i][j] = 1
                s[i][j] = 0
            elif a[j] == "*":
                w.append([i, j])
    bfs()
    result = s[d[0]][d[1]]
    if result != "D":
        print(result)
    else:
        print("KAKTUS")

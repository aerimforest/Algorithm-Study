def d():
    for i in range(n + 2):
        for j in range(n + 2):
            if i == j:
                continue
            if abs(s[i][0] - s[j][0]) + abs(s[i][1] - s[j][1]) <= 1000:
                s_[i][j] = 1
                s_[j][i] = 1


def dfs(start):
    visit[start] = 1
    for i in range(n + 2):
        if s_[start][i] == 1 and visit[i] == 0:
            dfs(i)


t = int(input())
for i in range(t):
    n = int(input())
    s = [list(map(int, input().split())) for i in range(n + 2)]
    s_ = [[0] * (n + 2) for i in range(n + 2)]
    visit = [0 for i in range(n + 2)]
    d()
    dfs(0)
    if visit[n + 1] == 1:
        print("happy")
    else:
        print("sad")

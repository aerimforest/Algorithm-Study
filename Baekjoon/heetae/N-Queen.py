import sys

input = sys.stdin.readline

n = int(input())
queen = [0] * n
result = 0


def isAdjecent(idx):
    for i in range(idx):
        if queen[idx] == queen[i] or abs(queen[idx] - queen[i]) == idx - i:
            return False

    return True


def dfs(idx):
    if idx == n:
        global result
        result += 1
        return

    for i in range(n):
        queen[idx] = i
        if isAdjecent(idx):
            dfs(idx + 1)


dfs(0)
print(result)

import sys
input = sys.stdin.readline

def dfs(start):
    stk = []
    stk.append(start)
    visited = [False] * (n + 1)
    cnt = 0
    while stk:
        node = stk.pop()
        cnt += 1
        if nums[node] == start:
            return cnt
        if not visited[nums[node]]:
            stk.append(nums[node])
            visited[node] = True
    return 0

n = int(input())
nums = [0] + list(map(int,input().split()))
ans = []
for i in range(1, n+1):
    ans.append(dfs(i))

print(max(ans))
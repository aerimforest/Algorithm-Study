import sys
input = sys.stdin.readline

def dfs(start):
    stk = []
    stk.append(start)
    visited = [False] * (n + 1)
    low, high = set(), set()
    high.add(start)
    low.add(nums[start])

    while stk:
        node = stk.pop()
        if nums[node] == start:
            high.add(node)
            low.add(nums[node])
            return list(high) if high == low else []
        if not visited[nums[node]]:
            high.add(node)
            low.add(nums[node])
            stk.append(nums[node])
            visited[node] = True
    return []

n = int(input())
nums = [0] + [int(input()) for _ in range(n)]
ans = []
for i in range(1, n+1):
    res = dfs(i)
    if res:
        ans.extend(res)
ans = set(ans)
print(len(ans), *sorted(ans), sep='\n')
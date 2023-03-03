import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))

dp_lis = [[0,0] for _ in range(n+1)]
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

visited = [True]*(n+1)

def dp(cur):
    dp_lis[cur][0] = nums[cur-1]
    dp_lis[cur][1] = 0
    visited[cur] = False

    for next in tree[cur]:
        if visited[next]:
            dp(next)
            dp_lis[cur][0] += dp_lis[next][1]
            dp_lis[cur][1] += max(dp_lis[next][0], dp_lis[next][1])
    
dp(1)
print(max(dp_lis[1]))
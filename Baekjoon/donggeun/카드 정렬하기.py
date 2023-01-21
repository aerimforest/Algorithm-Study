import sys, heapq
input = sys.stdin.readline

n = int(input())
h = []
ans = 0
i,j = 0,0
[heapq.heappush(h,int(input().rstrip())) for _ in range(n)]
while h:
    if i > 2:
        heapq.heappush(h, j)
        j = heapq.heappop(h)
        j += heapq.heappop(h)
        ans += j
    elif n == 1:
        break
    elif i == 2:
        j = ans
    else:
        ans += heapq.heappop(h)
    i += 1
print(ans)
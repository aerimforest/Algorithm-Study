import sys, heapq
input = sys.stdin.readline

n,k = map(int,input().split())
ans = 0
h = []
for _ in range(n):
    heapq.heappush(h, list(map(int,input().split())))

backs = sorted([int(input()) for _ in range(k)])
candi = []
for back in backs:
    
    while h and back >= h[0][0]:
        heapq.heappush(candi, -heapq.heappop(h)[1])
    
    if candi:
        ans -= heapq.heappop(candi)

print(ans)
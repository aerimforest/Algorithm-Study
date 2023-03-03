from collections import defaultdict
import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

st,ed = 0, k

while st <= ed:
    mid = (st+ed)//2
    cnt = 0

    for i in range(1, n+1):
        cnt += min(mid//i, n)
    
    if cnt >= k:
        ed = mid - 1
    else:
        st = mid + 1

print(st)
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
immigration_time = [int(input()) for _ in range(n)]

st = 1
ed = max(immigration_time)*n
ans = []
while st <= ed:
    mid = (st+ed)//2
    cnt = sum(mid//time for time in immigration_time)
    if cnt >= m:
        ans.append(mid)
        ed = mid - 1
        continue
    st = mid + 1

print(min(ans))

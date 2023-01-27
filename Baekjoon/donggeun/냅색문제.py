# 아무리 생각해도 풀이방법이 떠오르지 않는다,,,
from itertools import combinations
import sys
input = sys.stdin.readline

n,c = map(int,input().split())
nums = list(map(int,input().split()))
ans = 1

for i in range(1,n+1):
    for x in combinations(nums, i):
        if sum(x) <= c:
            ans += 1

print(ans)
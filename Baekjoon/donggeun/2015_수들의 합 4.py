import sys
from collections import defaultdict
input = sys.stdin.readline

n,k = map(int,input().split())
nums = list(map(int,input().split()))
pre_fix = [0]
pre_map = defaultdict(int)
ans = 0


for i in range(n):
    pre_fix.append(pre_fix[-1]+nums[i])
    
    if pre_fix[i+1] == k:
        ans += 1

    # 누적합(i) - k 값의 등장 횟수 만큼 ans에 추가
    ans += pre_map[pre_fix[i+1]-k]
    # 누적합(i) 기록
    pre_map[pre_fix[i+1]] += 1

print(ans)
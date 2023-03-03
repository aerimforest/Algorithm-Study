import sys
input = sys.stdin.readline

n,s = map(int,input().split())
nums = list(map(int,input().split()))

pre_fix = [0]
for num in nums:
    pre_fix.append(num+pre_fix[-1])

st,ed = 0,1
ans = 100001
while ed <= n:
    tmp = pre_fix[ed] - pre_fix[st]
    if tmp == s:
        ans = min(ans, ed-st)
        ed += 1
    elif tmp < s:
        ed += 1
    else:
        ans = min(ans, ed-st)
        st += 1
print(ans if ans != 100001 else 0)
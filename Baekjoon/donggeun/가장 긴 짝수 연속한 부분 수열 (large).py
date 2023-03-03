n,k = map(int,input().split())
nums = list(map(int,input().split()))

binary = [num%2 for num in nums]
pre_fix = [0]*(n+1)

for idx, val in enumerate(binary, 1):
    pre_fix[idx] = val + pre_fix[idx-1]

st,ed = 0, 1
ans = 0

while st <= ed and ed <= n:
    tmp = pre_fix[ed] - pre_fix[st]
    if tmp <= k:
        ans = max(ans, ed - st - tmp)
        ed += 1
    else:
        st += 1
print(ans)
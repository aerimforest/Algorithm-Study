import sys
input=sys.stdin.readline
n=int(input())
nums=list(map(int,input().split()))
dp=[0 for _ in range(n)]
dp[0] = nums[0]

for i in range(1, n):
    max_num = nums[i] # 그냥 하나만 선택한경우
    for j in range(1,n):
        if max_num<dp[i-j]+nums[j-1] and i-j>-1:
            max_num=dp[i-j]+nums[j-1]
        if i-j<0:
            break
    dp[i]= max_num

print(dp[n-1])
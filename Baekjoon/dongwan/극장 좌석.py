N = int(input())
M= int(input())
seat = [0]*(N)
for i in range(M) :
    vip = int(input())
    seat[vip-1] = 1 

dp = [0]*(N+1)

dp[0] = 1 
dp[1] = 1 
dp[2] = 2 

for i in range(3,N+1) :
    dp[i] = dp[i-1]+dp[i-2]
print(dp)


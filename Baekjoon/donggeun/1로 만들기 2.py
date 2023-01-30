n = int(input())
dp = [0]*(n+1)
way = [[] for _ in range(n+1)]
way[1] = [1]
for i in range(2, n+1):
    two = False
    three = False
    way[i] = way[i-1][:]+[way[i-1][-1]+1]

    dp[i] = dp[i-1]+1
    if i%2 ==0 and dp[i//2]<dp[i]:
        dp[i] = dp[i//2]+1
        two = True
    if i%3 ==0 and dp[i//3]<dp[i]:
        dp[i] = dp[i//3]+1
        two = False
        three = True

    if two:
        way[i] = way[i//2][:]+[way[i//2][-1]*2]
    elif three:
        way[i] = way[i//3][:]+[way[i//3][-1]*3]

print(dp[n])
print(*reversed(way[n]))
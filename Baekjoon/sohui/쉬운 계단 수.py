n = int(input())
sum = 0
dp = [[0 for i in range(10)] for j in range(101)]

for i in range(1, 10):
    dp[1][i] = 1

for i in range(2, n + 1):
    for j in range(10):
        if j == 0:  # 모든 0열은 직전 행의 1열의 값을 가져와서 채운다.
            dp[i][j] = dp[i - 1][1]
        elif j == 9:  # 마찬가지로 모든 9열은 직전 행의 8열의 값을 가져와서 채운다.
            dp[i][j] = dp[i - 1][8]
        else:  # 그외의 경우 직전행의 직전열, 직후열의 값을 더한 값으로 채운다.
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]

for i in range(0, 10):
    sum += dp[n][i]
print(sum % 1000000000)
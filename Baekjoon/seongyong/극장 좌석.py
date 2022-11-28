
import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
vip = [int(sys.stdin.readline()) for _ in range(m)]

dp = [0] * (n + 1)
dp[0] = 1
dp[1] = 1  # 1
if n > 1:
    dp[2] = 2  # 1 2, 2 1
# dp[3] = 3 # 1 2 3, 1 3 2, 2 1 3

# 점화식 : dp[n] = dp[n - 1] + dp[n - 2]
for i in range(3, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2]

answer = 1  # 경우의 수
# vip의 유무에 따라 경우의 수를 도출
if m > 0:
    pre = 0
    # 반복문을 통해 vip 사이에 그룹에 들어가는 경우의 수를 확인
    for j in range(m):
        answer *= dp[vip[j] - 1 - pre]
        pre = vip[j]
    answer *= dp[n - pre]
else:
    answer = dp[n]
print(answer)

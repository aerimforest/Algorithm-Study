import sys

input = lambda: sys.stdin.readline()

n = int(input())
wines = [int(input()) for _ in range(n)]

dp = [0, wines[0]]

if n > 1:
    dp.append(wines[0] + wines[1])

for i in range(3, n + 1):
    case_1 = dp[i - 1]  # 이번 포도주를 마시지 않는 경우
    case_2 = dp[i - 2] + wines[i - 1]  # 이번 포도주를 마시고 이전 포도주를 안 마신 경우
    case_3 = dp[i - 3] + wines[i - 1] + wines[i - 2]  # 이번 포도주와 이전 포도주 모두 마신 경우

    dp.append(max(case_2, case_1, case_3))

print(dp[-1])

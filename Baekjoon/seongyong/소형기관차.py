import sys

input = sys.stdin.readline
N = int(input())
train = list(map(int, input().split()))
limit = int(input())

# 구간합 계산
S = [0]
value = 0
for t in train:
    value += t
    S.append(value)

dp = [[0] * (N + 1) for _ in range(4)]

# 점화식을 이용해 최댓값 탐색
for n in range(1, 4):
    for m in range(n * limit, N + 1):
        # n = 1일 때 선택한 객차가 없으므로
        # 전에 계산한 구간합과 현재 계산하는 구간합 중 최댓값을 계산해 갱신해준다.
        if n == 1:
            dp[n][m] = max(dp[n][m - 1], S[m] - S[m - limit])

        # 점화식
        else:
            dp[n][m] = max(dp[n][m - 1], dp[n - 1][m - limit] + S[m] - S[m - limit])
        # print_dp(dp)

print(dp[3][N])

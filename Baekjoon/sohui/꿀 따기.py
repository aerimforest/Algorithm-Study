n = int(input())
data = list(map(int, input().split()))

ans = 0
sum = [data[0]]

for i in range(1, n):
    sum.append(sum[i - 1] + data[i])
for i in range(1, n - 1):
    ans = max(ans, sum[n - 2] + sum[i - 1] - data[i])
for i in range(1, n - 1):
    ans = max(ans, sum[n - 1] - data[0] - data[i] + sum[n - 1] - sum[i])
for i in range(1, n - 1):
    ans = max(ans, sum[n - 2] - data[0] + data[i])

print(ans)
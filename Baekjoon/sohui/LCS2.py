a = input()
b = input()

len_a = len(a)
len_b = len(b)
dp = [[0] * (len_a + 1) for _ in range(len_b + 1)]

for i in range(1, len(b) + 1):
    for j in range(1, len(a) + 1):
        if b[i - 1] == a[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

ans = ""
now = dp[-1][-1]
y = len_b
x = len_a

while now != 0:
    if dp[y][x - 1] == now - 1 and dp[y - 1][x] == now - 1:
        ans = a[x - 1] + ans
        now -= 1
        y -= 1
        x -= 1
    else:
        if dp[y - 1][x] > dp[y][x - 1]:
            y -= 1
        else:
            x -= 1

print(dp[-1][-1])
print(ans)

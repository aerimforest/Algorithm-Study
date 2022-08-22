word1 = input()
word2 = input()

n = len(word1)
m = len(word2)

data = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        data[i][j] = data[i - 1][j]
        if word1[i - 1] == word2[j - 1]:
            data[i][j] = data[i - 1][j - 1] + 1
        else:
            data[i][j] = max(data[i][j - 1], data[i - 1][j])

print(data[n][m])
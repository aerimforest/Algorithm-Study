first, second = input(), input()
first_length, second_length = len(first), len(second)

lcs = [[0] * (first_length + 1) for _ in range(second_length + 1)]

for i in range(1, second_length + 1):
    for j in range(1, first_length + 1):
        if first[j - 1] == second[i - 1]:
            lcs[i][j] = lcs[i - 1][j - 1] + 1
        else:
            lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

print(lcs[-1][-1])

import sys


def get_max_honey():
    max_honey = 0

    for i in range(1, N):
        max_honey = max(max_honey, 2 * sum_matrix[-1] - matrix[0] - matrix[i] - sum_matrix[i])

    for i in range(1, N - 1):
        max_honey = max(max_honey, sum_matrix[-1] - matrix[-1] - matrix[i] + sum_matrix[i - 1])

    for i in range(1, N - 1):
        max_honey = max(max_honey, sum_matrix[i] - matrix[0] + sum_matrix[-1] - sum_matrix[i - 1] - matrix[-1])

    return max_honey


N = int(input())
matrix = list(map(int, sys.stdin.readline().split()))

sum_matrix = [m for m in matrix]
for idx in range(1, N):
    sum_matrix[idx] += sum_matrix[idx - 1]

print(get_max_honey())

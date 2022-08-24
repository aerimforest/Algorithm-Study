import sys


def get_max_honey():
    max_honey = 0

    for i in range(1, N - 1):
        first_1, second_1 = sum_matrix[-1] - matrix[0] - matrix[i], sum_matrix[-1] - sum_matrix[i]  # 벌 벌 통
        first_2, second_2 = sum_matrix[-1] - matrix[-1] - matrix[i], sum_matrix[i - 1]  # 통 벌 벌
        first_3, second_3 = sum_matrix[i] - matrix[0],  sum_matrix[-1] - sum_matrix[i - 1] - matrix[-1]  # 벌 통 벌

        max_honey = max(max_honey, first_1 + second_1, first_2 + second_2, first_3 + second_3)

    return max_honey


N = int(input())
matrix = list(map(int, sys.stdin.readline().split()))

sum_matrix = [num for num in matrix]

for idx in range(1, N):
    sum_matrix[idx] += sum_matrix[idx - 1]

print(get_max_honey())

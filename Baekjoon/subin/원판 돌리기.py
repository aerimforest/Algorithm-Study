from collections import deque
from copy import deepcopy

def find_same(N, M, matrix):
    move_x = [1, -1, 0, 0]
    move_y = [0, 0, 1, -1]

    matrix_copy = deepcopy(matrix)
    is_exists = False

    for r in range(N):
        for c in range(M):
            if matrix[r][c] == -1: continue
            cur_y = r
            cur_x = c

            for i in range(4):
                next_x = (cur_x + move_x[i]) % M
                next_y = cur_y + move_y[i]

                if next_x < 0 or next_x >= M or next_y < 0 or next_y >= N:
                    continue
                if matrix[cur_y][cur_x] == matrix[next_y][next_x]:
                    is_exists = True
                    matrix_copy[cur_y][cur_x] = -1
                    matrix_copy[next_y][next_x] = -1

    if not is_exists:
        total_sum = 0
        total_num = 0

        for r in range(N):
            for c in range(M):
                if matrix_copy[r][c] == -1: continue
                total_sum += matrix_copy[r][c]
                total_num += 1

        if not total_num:
            return matrix_copy
        average = total_sum / total_num


        for r in range(N):
            for c in range(M):
                if matrix[r][c] == -1: continue
                if matrix[r][c] > average:
                    matrix_copy[r][c] = matrix[r][c] - 1
                elif matrix[r][c] < average:
                    matrix_copy[r][c] = matrix[r][c] + 1
    return matrix_copy

def solution():

    N, M, T = map(int, input().split())
    matrix = [deque() for _ in range(N)]
    for r in range(N):
        matrix[r] = deque(list(map(int, input().split())))

    for t in range(T):
        x, d, k = map(int, input().split()) # 원판 idx, 방향(0: 시계, 1: 반시계), 크기
        if not d: # 시계
            x_k = x
            cnt = 1
            while x_k * cnt <= N:
                for _ in range(k):
                    matrix[x_k * cnt - 1].appendleft(matrix[x_k * cnt - 1].pop())
                cnt += 1
        else: # 반시계
            x_k = x
            cnt = 1
            while x_k * cnt <= N:
                for _ in range(k):
                    matrix[x_k * cnt - 1].append(matrix[x_k * cnt - 1].popleft())
                cnt += 1

        matrix = find_same(N, M, matrix)

    answer = 0
    for r in range(N):
        for c in range(M):
            if matrix[r][c] == -1: continue
            answer += matrix[r][c]
    return answer


if __name__ == '__main__':
    print(solution())
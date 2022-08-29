from collections import deque, defaultdict

N, M, K = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
tree = [[defaultdict(int) for _ in range(N)] for _ in range(N)]
arr = [[5] * N for _ in range(N)]
for _ in range(M):
    x, y, z = map(int, input().split())
    tree[x-1][y-1][z] += 1

d = [[-1,0], [1,0], [0,-1], [0,1], [-1,-1], [-1,1], [1,-1], [1,1]]

def solution():
    ret = 0

    def solve():
        global tree, arr, A
        temp = [[defaultdict(int) for _ in range(N)] for _ in range(N)]
        for x in range(N):
            for y in range(N):
                if not tree[x][y]:
                    arr[x][y] += A[x][y]
                    continue
                die, spread = 0, 0
                for age, num in sorted(tree[x][y].items()):
                    cnt = arr[x][y] // age
                    if cnt >= num:
                        arr[x][y] -= age * num
                        temp[x][y][age+1] += num
                        if (age+1) % 5 == 0:
                            spread += num
                    elif 1 <= cnt < num:
                        arr[x][y] -= age * cnt
                        temp[x][y][age+1] += cnt
                        die += (age//2) * (num-cnt)
                        if (age+1) % 5 == 0:
                            spread += cnt
                    else:
                        die += (age//2) * num
                if spread != 0:
                    for dx, dy in d:
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < N and 0 <= ny < N:
                            temp[nx][ny][1] += spread
                arr[x][y] += A[x][y] + die
        return temp

    for _ in range(K):
        global tree
        tree = solve()

    for x in range(N):
        for y in range(N):
            ret += sum(tree[x][y].values())

    return ret

print(solution())
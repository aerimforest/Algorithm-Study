import sys


def solution(prev, count, hp):
    if count == 0:
        x, y = milk[prev]
        distance = abs(home[0] - x) + abs(home[1] - y)

        if distance <= hp:
            return True
        return False

    if hp <= 0:
        return False

    for idx in range(len(milk)):
        if not visited[idx]:
            visited[idx] = True

            x, y = milk[idx]
            p_x, p_y = None, None

            if prev == -1:  # 처음 시작일 경우
                p_x, p_y = home[0], home[1]
            else:  # 중간 단계일 경우
                p_x, p_y = milk[prev][0], milk[prev][1]

            distance = abs(p_x - x) + abs(p_y - y)
            if distance <= hp:
                if solution(idx, count - 1, hp - distance + h):
                    return True
            visited[idx] = False


n, m, h = map(int, input().split())

home = None
town, milk = [], []

for i in range(n):
    town.append(list(map(int, sys.stdin.readline().split())))

    for j in range(n):
        if town[i][j] == 2:
            milk.append((i, j))
        elif town[i][j] == 1:
            home = (i, j)

answer = 0
visited = [False] * len(milk)

for count in range(len(milk), 0, -1):
    if solution(-1, count, m):
        answer = count
        break

print(answer)

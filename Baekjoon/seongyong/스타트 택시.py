import math
from collections import deque

n, m, energy = map(int, input().split(' '))
graph = [list(map(int, input().split(' '))) for _ in range(n)]
s_x, s_y = map(int, input().split(' '))
people = [list(map(int, input().split(' '))) for _ in range(m)]

d_x = [-1, 0, 1, 0]
d_y = [0, 1, 0, -1]


def bfs(s_x, s_y):
    visited = [[-1] * n for _ in range(n)]
    queue = deque()
    queue.append((s_x, s_y))
    visited[s_x][s_y] = 0

    while queue:
        pop_x, pop_y = queue.popleft()

        for i in range(4):
            n_x, n_y = pop_x + d_x[i], pop_y + d_y[i]

            if n_x < 0 or n_x >= n or n_y < 0 or n_y >= n:
                continue
            if graph[n_x][n_y] == 1 or visited[n_x][n_y] != -1:
                continue

            visited[n_x][n_y] = visited[pop_x][pop_y] + 1
            queue.append((n_x, n_y))

    return visited


def check_dist(visited: list, people: list):
    i = 0
    for p_x, p_y, a_x, a_y in people:
        people[i].append(visited[p_x - 1][p_y - 1])
        i += 1

    people.sort(key=lambda x: (-x[4], -x[0], -x[1]))


def solve(s_x, s_y):
    global energy
    while people:
        visitied = bfs(s_x - 1, s_y - 1)
        check_dist(visitied, people)
        p_x, p_y, a_x, a_y, dist = people.pop()

        for temp in people:
            temp.pop()

        visitied = bfs(p_x - 1, p_y - 1)
        dist2 = visitied[a_x - 1][a_y - 1]
        s_x, s_y = a_x, a_y

        if dist == -1 or dist2 == -1:
            print(-1)
            return

        energy -= dist
        if energy < 0:
            break

        energy -= dist2
        if energy < 0:
            break

        energy += dist2 * 2

    if energy < 0:
        print(-1)
    else:
        print(energy)


solve(s_x, s_y)

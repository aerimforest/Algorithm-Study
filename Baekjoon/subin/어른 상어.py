from collections import defaultdict

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def smell_shark(visited, shark_location, k):
    for shark, (i, j, _) in shark_location.items():
        visited[i][j] = (shark, k)

def time_count(visited, n):
    for i in range(n):
        for j in range(n):
            t = visited[i][j]
            if t: # not empty space
                if t[1]-1 > 0:
                    visited[i][j] = (t[0], t[1]-1)
                else:
                    visited[i][j] = 0

def move_shark(space, visited, shark_location, shark_priority, n):
    moved_location = defaultdict(lambda: list())
    for shark, (y, x, d) in shark_location.items():
        cnt = 0
        for t in range(4):
            direction = shark_priority[(shark, d)][t]
            nx = x + dx[direction]
            ny = y + dy[direction]
            if 0 <= nx < n and 0 <= ny < n and not visited[ny][nx]: # empty space search
                space[y][x] = 0
                shark_location[shark] = (ny, nx, direction)
                moved_location[(ny, nx)].append(shark)
                cnt = 1
                break
        if cnt == 0: # not empty space
            for t in range(4):
                direction = shark_priority[(shark, d)][t]
                nx = x + dx[direction]
                ny = y + dy[direction]
                if 0 <= nx < n and 0 <= ny < n and visited[ny][nx] and visited[ny][nx][0] == shark:
                    space[y][x] = 0
                    shark_location[shark] = (ny, nx, direction)
                    moved_location[(ny, nx)].append(shark)
                    break

    for k, v in moved_location.items():
        if len(v) == 1: # move the shark
            y, x, d = shark_location[v[0]]
            space[y][x] = v[0]
        else: # kill the sharks and move the shark
            v.sort()
            y, x, d = shark_location[v[0]]
            space[y][x] = v[0]
            for i in v[1:]:
                shark_location.pop(i)

if __name__ == '__main__':
    n, m, k = list(map(int, input().split()))
    space = []
    shark_location = dict()
    for i in range(n):
        s = list(map(int, input().split()))
        space.append(s)
        for j, shark in enumerate(s):
            if shark != 0:
                shark_location[shark] = (i, j)

    # add shark direction information to shark_location dictionary
    for e, i in enumerate(list(map(int, input().split()))):
        shark_location[e+1] = shark_location[e+1] + (i-1, )

    shark_priority = dict()
    for i in range(1, m+1):
        for j in range(4):
            shark_priority[(i, j)] = [t-1 for t in list(map(int, input().split()))]

    visited = [[False] * n for _ in range(n)] # this array includes smells' shark number and remaining time
    smell_shark(visited, shark_location, k) # initial point

    ans = 0
    while True:
        move_shark(space, visited, shark_location, shark_priority, n)
        time_count(visited, n)
        smell_shark(visited, shark_location, k)
        ans += 1
        # terminal condition
        if len(shark_location) == 1:
            print(ans)
            break
        elif ans==1000:
            print(-1)
            break
def find_set(node):
    if node != parent[node]:
        parent[node] = find_set(parent[node])

    return parent[node]


N = int(input())
M = int(input())
info = [list(map(int, input().split())) for _ in range(N)]
travel = list(map(int, input().split()))

parent = list(range(N + 1))

for i in range(N):
    for j in range(N):
        if info[i][j] == 1:
            x_root, y_root = find_set(i + 1), find_set(j + 1)

            if x_root != y_root:
                parent[y_root] = x_root

result = 'YES'
root = parent[travel[0]]
for i in travel:
    if root != find_set(i):
        result = 'NO'
        break

print(result)
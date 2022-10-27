h, w, x, y = map(int, input().split())

ans = []
graph = []
for _ in range(h+x):
    graph.append(list(map(int, input().split())))

for i in range(h):
    ans.append(graph[i][:w])

for i in range(h):
    for j in range(w):
        if i+x < h and j+y < w:
            ans[i+x][j+y] -= ans[i][j]

for a in ans:
    print(" ".join(map(str,a)))
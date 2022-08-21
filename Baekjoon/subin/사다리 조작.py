n, m, h = map(int, input().split())
visited = [[False] * (n+1) for _ in range(h+1)]
for _ in range(m):
	a, b = map(int, input().split())
	visited[a][b] = True
combi = []
def dfs(depth, idx):
	global answer
	if depth >= answer:
		return
	if check():
		answer = min(answer, depth)
		return
	for c in range(idx, len(combi)):
		x, y = combi[c]
		if not visited[x][y-1] and not visited[x][y+1]:
			visited[x][y] = True
			dfs(depth+1, c+1)
			visited[x][y] = False


def check():
	for i in range(1, n+1):
		now = i
		for j in range(1, h+1):
			if visited[j][now-1]:
				now -= 1
			elif visited[j][now]:
				now += 1
		if now != i:
			return False
	return True

for i in range(1, h+1):
	for j in range(1, n):
		if not visited[i][j-1] and not visited[i][j] and not visited[i][j+1]:
			combi.append([i, j])
answer = 4
dfs(0, 0)
print(answer if answer < 4 else -1)
import sys
from collections import deque

maxdis = 100001

def bfs(x, y):
  dq = deque()
  dqlog = deque()
  dq.append(x)

  while dq:
    a = dq.popleft()
    dqlog.append(a)
    if a == y:
      print(dis[a])
      mv(a)
      break

    for i in (a - 1, a + 1, 2 * a):
      if 0 <= i < maxdis and not dis[i]:
        dis[i] = dis[a] + 1
        dq.append(i)
        move[i] = a

def mv(x):
  ls = []
  tmp = x

  for _ in range(dis[x] + 1):
    ls.append(tmp)
    tmp = move[tmp]

  print(" ".join(map(str, ls[::-1])))


n, k = map(int, sys.stdin.readline()[:-1].split())
dis = [0] * maxdis
move = [0] * maxdis
bfs(n, k)
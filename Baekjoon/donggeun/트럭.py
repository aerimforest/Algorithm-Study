from collections import deque
import sys
input = sys.stdin.readline

n, w, l = map(int, input().split())
q = deque(map(int, input().split()))
 
b = deque([0] * w)
ans = 0
while b:
	ans += 1
	b.popleft()
	if q:
		if sum(b) + q[0] <= l:
			b.append(q.popleft())
		else:
			b.append(0)
print(ans)
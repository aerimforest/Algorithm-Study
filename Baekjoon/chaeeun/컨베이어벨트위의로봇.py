# (참고)

from collections import deque

n, k = map(int, input().split())
belt = deque(map(int, input().split()))
robots = deque([0]*2*n)

level = 1
while 1:

  ### 벨트가 한 칸 회전
	belt.rotate(1)
	robots.rotate(1)
	robots[n-1] = 0

  ### 가장 먼저 벨트에 올라간 로봇부터
  ### 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동
  ### 만약 이동할 수 없다면 가만히 있음
	for i in range(n-2,-1,-1):
		if robots[i] and not robots[i+1] and belt[i+1]:
			belt[i+1] -= 1 # 내구도 감소
			robots[i+1], robots[i] = robots[i], 0
	robots[n-1] = 0

  ### 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 함
  ### 올라가는 위치에 로봇이 없다면 로봇을 하나 올림
	if not robots[0] and belt[0]:
		robots[0] = 1
		belt[0] -= 1

  ### 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료
  ### 그렇지 않다면 다시 처음부터 반복
	if belt.count(0) >= k:
		print(level)
		break
	level += 1
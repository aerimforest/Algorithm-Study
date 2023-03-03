# [2134] 창고 이전
import sys
input = sys.stdin.readline

n,m,k = map(int, input().split())

nList = [0]*n
mList = [0]*m
for i in range(n):
    nList[i] = int(input())

for i in range(m):
    mList[i] = int(input())

# n층짜리 창고에 있는 물품을 m층짜리 창고에 다 옮김
## n -> m
## 출력 : 옮길 수 있는 최대 물품 개수, y : 드는 비용 최솟값

x, y = 0, 0

nidx, midx = 0, 0
while nidx < n and midx < m: # 서로 하나라도 개수 넘어가면 종료
    if nList[nidx] == 0: # 해당 층에 남은 짐 없으면 continue
        nidx += 1
        continue
    if mList[midx] == 0: # 옮겨야 하는 곳에 짐 꽉 차면 continue
        midx += 1
        continue
    
    x +=1
    y += (nidx+1) + (midx+1)

    nList[nidx] -= 1
    mList[midx] -= 1

print(x, y)


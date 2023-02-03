import sys, heapq
input = sys.stdin.readline

n = int(input())
task = sorted([list(map(int,input().split())) for _ in range(n)], key=lambda x:(x[0], x[1]))
room = []
heapq.heappush(room, 1)

for st, ed in task:
    
    ed_time = heapq.heappop(room)
    if ed_time <= st:
        heapq.heappush(room, ed)
    else:
        heapq.heappush(room, ed_time)
        heapq.heappush(room, ed)

print(len(room))

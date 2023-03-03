import sys, heapq
input = sys.stdin.readline

n = int(input())
times = sorted([list(map(int,input().split())) for _ in range(n)], key=lambda x: (x[1], x[0]))

room = []
heapq.heappush(room, 0)
ans = 1
for no, st, ed in times:
    room_ed = heapq.heappop(room)
    if st >= room_ed:
        heapq.heappush(room, ed)
    else:
        ans += 1
        heapq.heappush(room, room_ed)
        heapq.heappush(room, ed)

print(ans)
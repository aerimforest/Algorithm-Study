import heapq

num = int(input())
min_heap = []

for _ in range(num):
    number = int(input())
    
    if number == 0:
        if len(min_heap):
            print(heapq.heappop(min_heap))
        else:
            print(0)
    else:
        heapq.heappush(min_heap, number)
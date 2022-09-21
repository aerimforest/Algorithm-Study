import heapq

num = int(input())

lst = list(int(input()) for i in range(num))
heapq.heapify(lst) # 힙으로 만들어주기
answer = 0

while len(lst) != 1:
    first_num = heapq.heappop(lst)
    second_num = heapq.heappop(lst)
    sum = first_num + second_num
    answer += sum
    heapq.heappush(lst, sum)

print(answer)
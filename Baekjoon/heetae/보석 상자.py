import sys

input = sys.stdin.readline

n, m = list(map(int, input().split()))

jewels = []
end = 0
for _ in range(m):
    input_jewel = int(input().rstrip())
    jewels.append(input_jewel)
    end = max(end, input_jewel)

answer = end
start = 1

while start <= end:
    mid = (start + end) // 2

    person_per_jewel = 0
    for jewel in jewels:
        quotient = jewel // mid
        remainder = jewel % mid

        person_per_jewel += quotient

        if remainder > 0:
            person_per_jewel += 1

    if person_per_jewel > n:
        start = mid + 1
    else:
        answer = min(answer, mid)
        end = mid - 1

print(answer)

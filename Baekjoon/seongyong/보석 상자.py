import sys

n, m = list(map(int, sys.stdin.readline().split()))

jewels = []
end = 0
for _ in range(m):
    input_jewel = int(sys.stdin.readline().rstrip())
    jewels.append(input_jewel)
    end = max(end, input_jewel)

answer = end

# 1명 당 나눠줘야 하는 보석 개수 = 최소 1개 ~ 보석함 내 최대 보석 개수
start = 1

while start <= end:
    # 이분탐색을 활용하면 O(logN)의 탐색을 할 수 있다.
    mid = (start + end) // 2

    # 보석 1 종류를 mid 만큼 나눠줬을 때 필요한 사람의 수
    person_per_jewel = 0
    for jewel in jewels:
        # 몫과 나머지를 구한다.
        quotient = jewel // mid
        remainder = jewel % mid

        person_per_jewel += quotient
        # 나머지가 존재하면, 해당 보석을 모두 나눠줘야 하므로 1명 더 추가해야 한다.
        if remainder > 0:
            person_per_jewel += 1

    # 보석이 아직 남았다면, 즉 나눠줘야할 사람이 더 필요하다면
    if person_per_jewel > n:
        start = mid + 1
    # 보석을 n명의 사람에게 전부 나눠줄 수 있다면,
    else:
        answer = min(answer, mid)
        end = mid - 1

print(answer)

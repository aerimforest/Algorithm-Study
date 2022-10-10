n = int(input()) # 저울 추의 개수
data = list(map(int, input().split())) # 추의 무게
data.sort()

target = 1
for x in data:
    if target < x:
        break
    target += x

print(target)

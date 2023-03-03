import sys
input = sys.stdin.readline

n,h = map(int,input().split())
stalagmites = [] # 석순
stalactites = [] # 종유석

def count_obstacle(obstacles: list, cut: int) -> int:
    st,ed = 0, n//2

    while st < ed:
        mid = (st + ed) //2
        if obstacles[mid] < cut:
            st = mid + 1
        else:
            ed = mid
    return ed

for i in range(n//2):

    stalagmites.append(int(input()))
    stalactites.append(int(input()))

stalagmites.sort()
stalactites.sort()

ans_list = []

for i in range(1, h+1):
    ans_list.append(n//2 - count_obstacle(stalagmites, i) + n//2 - count_obstacle(stalactites, h-i+1))

print(min(ans_list), ans_list.count(min(ans_list)))

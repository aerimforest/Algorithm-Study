import sys
input = lambda : sys.stdin.readline().strip()

k = int(input())
sign = list(input().split())
visited = [0] * 10
_min = ''
_max = ''

def check(i, j, k):
    if k == '<':
        return i < j
    else:
        return i > j

def solve(cnt, s):
    global _min, _max
    # 부등호 개수 +1만큼 문자열 구성된 경우
    if cnt == k + 1:
        if not len(_min):
            _min = s
        else:
            _max = s
        return

    for i in range(10):
        if not visited[i]:
            if cnt == 0 or check(s[-1], str(i), sign[cnt - 1]):
                visited[i] = 1
                solve(cnt+1, s + str(i))
                visited[i] = 0


solve(0, '')
print(_max)
print(_min)

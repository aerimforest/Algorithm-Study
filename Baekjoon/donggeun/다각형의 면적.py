import sys
input = sys.stdin.readline

def ccw(x1: int, x2: int, x3: int, y1: int, y2: int, y3: int) -> float:
    return ((x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1))/2

n = int(input())
ans = 0

cen_x, cen_y = map(int,input().split())
two_x, two_y = map(int,input().split())
for _ in range(n-2):
    x,y = map(int,input().split())
    ans += ccw(cen_x, two_x, x, cen_y, two_y, y)
    two_x, two_y = x,y

print(abs(ans))
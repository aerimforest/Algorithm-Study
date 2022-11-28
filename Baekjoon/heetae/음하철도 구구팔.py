import math
import sys

input = sys.stdin.readline


def get_gcd(a, b):
    while b:
        a, b = b, a % b
    return a


def check_dis(x, y):
    return math.sqrt((x - xs) ** 2 + (y - ys) ** 2)


xs, ys = map(int, input().split())
xe, ye, dx, dy = map(int, input().split())

d_gcd = get_gcd(dx, dy)
dx, dy = dx // d_gcd, dy // d_gcd

curX, curY = xe, ye
while check_dis(curX, curY) > check_dis(curX + dx, curY + dy):
    curX += dx
    curY += dy

print(curX, curY)

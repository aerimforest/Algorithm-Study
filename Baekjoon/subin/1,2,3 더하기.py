t = int(input())

def dynamic(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    return dynamic(n-1) + dynamic(n-2) + dynamic(n-3)

for _ in range(t):
    n = int(input())
    print(dynamic(n))
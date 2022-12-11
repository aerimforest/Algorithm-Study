import sys

if __name__ == '__main__':
    _ = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split(' ')))
    table = [1 for i in range(len(a))]

    for now in range(1, len(a)):
        for pre in range(now):
            if a[now] > a[pre]: table[now] = max(table[pre] + 1, table[now])

    print(max(table))

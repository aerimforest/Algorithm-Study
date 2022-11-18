import sys

if __name__ == '__main__':
    n, k = map(int, sys.stdin.readline().rstrip('\n').split(' '))
    stuff_list = [list(map(int, sys.stdin.readline().rstrip('\n').split(' '))) for i in range(n)]
    table = [[0] * (1 + k) for stuff in range(1 + len(stuff_list))]

    for capacity in range(1, 1 + k):
        for stuff_i, stuff in enumerate(stuff_list, start=1):
            weight, value = stuff
            if weight <= capacity:
                table[stuff_i][capacity] = max(table[stuff_i - 1][capacity - weight] + value,
                                               table[stuff_i - 1][capacity])
            else:
                table[stuff_i][capacity] = table[stuff_i - 1][capacity]

    print(table[-1][-1])

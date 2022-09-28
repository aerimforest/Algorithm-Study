import sys

n = int(sys.stdin.readline())
video = [sys.stdin.readline().rstrip("\n") for _ in range(n)]
quadTree = list()


def isCompressable(lu_x: int, lu_y: int, l: int):
    for y in range(lu_y, lu_y + l):
        for x in range(lu_x, lu_x + l):
            if video[y][x] != video[lu_y][lu_x]: return False

    return True


def compress(lu_x: int, lu_y: int, length: int):
    if isCompressable(lu_x, lu_y, length):
        quadTree.append(video[lu_y][lu_x])
        return

    length //= 2
    quadTree.append('(')
    compress(lu_x, lu_y, length)
    compress(lu_x + length, lu_y, length)
    compress(lu_x, lu_y + length, length)
    compress(lu_x + length, lu_y + length, length)
    quadTree.append(')')


if __name__ == '__main__':
    compress(0, 0, n)
    for c in quadTree: print(c, end="")

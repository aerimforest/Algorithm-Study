import sys

input = sys.stdin.readline

while True:
    try:
        size = int(input()) * 10000000
        n = int(input())
        lego = [int(input()) for _ in range(n)]
        lego.sort()
        i, j = 0, n - 1
        while i < j:
            if lego[i] + lego[j] == size:
                print("yes %d %d" % (lego[i], lego[j]))
                break
            elif lego[i] + lego[j] > size:
                j -= 1
            elif lego[i] + lego[j] < size:
                i += 1
        else:
            print("danger")
    except:
        break

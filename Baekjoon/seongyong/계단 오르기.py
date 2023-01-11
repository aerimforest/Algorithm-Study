import sys

if __name__ == '__main__':
    stairs = list()
    for i in range(int(sys.stdin.readline())): stairs.append(int(sys.stdin.readline()))
    if len(stairs) == 1:
        print(stairs[0])
        quit()

    front_o, front_x = [0 for i in range(len(stairs))], [0 for i in range(len(stairs))]
    front_o[0], front_o[1] = stairs[0], stairs[0] + stairs[1]
    front_x[0], front_x[1] = 0, stairs[1]

    for i in range(2, len(stairs)):
        front_o[i] = stairs[i] + \
                     max(front_x[i - 1], front_x[i - 2], \
                         front_o[i - 2])

        front_x[i] = stairs[i] + \
                     max(front_o[i - 2], front_x[i - 2])

    print(max(front_x[-1], front_o[-1]))

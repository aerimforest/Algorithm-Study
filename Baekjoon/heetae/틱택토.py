ind = [[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]


def check(ttt, typ):
    for [a, b, c] in ind:
        if ttt[a] == typ and ttt[a] == ttt[b] == ttt[c]:
            return True
    return False


while True:
    ttt = input().rstrip()
    if ttt == "end":
        break

    cnt_o = ttt.count("O")
    cnt_x = ttt.count("X")

    if cnt_x != (cnt_o + 1) and cnt_x != cnt_o:
        print("invalid")
        continue

    win, lose = ('X', 'O') if cnt_x == cnt_o + 1 else ('O', 'X')
    win_res = check(ttt, win)
    lose_res = check(ttt, lose)

    if lose_res:
        print("invalid")
    elif not win_res:
        if ttt.count('.') == 0:
            print("valid")
        else:
            print("invalid")
    else:
        print("valid")

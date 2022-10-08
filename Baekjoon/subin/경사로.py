N, L = map(int, input().split())
board = []
for _ in range(N):
    board.append(list(map(int, input().split())))

count = 0
for i in range(N):
    row = [board[i][0], 1]
    check = False
    for j in range(1, N):
        if board[i][j - 1] == board[i][j]:
            row[1] += 1
            continue
        elif abs(board[i][j - 1] - board[i][j]) != 1:
            break
        elif board[i][j - 1] < board[i][j]:
            if row[1] < L or (check and row[1] < L * 2):
                break
            check = False
        else:
            if check:
                if row[1] < L:
                    break
            check = True
        row = [board[i][j], 1]
    else:
        if not check or row[1] >= L:
            count += 1

    col = [board[0][i], 1]
    check = False
    for j in range(1, N):
        if board[j - 1][i] == board[j][i]:
            col[1] += 1
            continue
        elif abs(board[j - 1][i] - board[j][i]) != 1:
            break
        elif board[j - 1][i] < board[j][i]:
            if col[1] < L or (check and col[1] < L * 2):
                break
            check = False
        else:
            if check:
                if col[1] < L:
                    break
            check = True
        col = [board[j][i], 1]
    else:
        if not check or col[1] >= L:
            count += 1

print(count)
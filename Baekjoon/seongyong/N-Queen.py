NONE = -1


def is_possible(row_to_put, col_to_put, queen_at_col):
    for pre_col in range(col_to_put):
        if queen_at_col[pre_col] == row_to_put \
                or queen_at_col[pre_col] + (col_to_put - pre_col) == row_to_put \
                or queen_at_col[pre_col] - (col_to_put - pre_col) == row_to_put:
            return False

    return True


def count_queen_position(queen_at_col, col_to_put):
    if col_to_put == len(queen_at_col):
        return 1

    counted = 0
    for row_to_put in range(len(queen_at_col)):
        if is_possible(row_to_put, col_to_put, queen_at_col):
            queen_at_col[col_to_put] = row_to_put
            counted += count_queen_position(queen_at_col, col_to_put + 1)

    return counted


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    n = int(input())
    queen_at_col = [NONE] * n
    print(count_queen_position(queen_at_col, 0))

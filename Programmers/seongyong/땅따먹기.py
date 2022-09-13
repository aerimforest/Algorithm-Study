def solution(land):
    table: list[list] = [[0 for _ in range(len(land[0]))]
                         for _ in range(len(land))]
    table[0] = land[0]
    for r in range(1, len(land)):
        for c in range(len(land[r])):
            max_in_row = 0
            for i in range(len(table[r - 1])):
                if i != c: max_in_row = max(table[r - 1][i], max_in_row)

            table[r][c] = land[r][c] + max_in_row

    return max(table[-1])

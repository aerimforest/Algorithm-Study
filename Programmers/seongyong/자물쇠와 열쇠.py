def moved(keys: set, lock_size: int, _dir):
    result = list()
    for key in keys:
        r, c = key
        dr, dc = _dir
        r += dr
        c += dc
        if 0 <= r < lock_size and 0 <= c < lock_size:
            result.append((r, c))

    return set(result)


def rotated_90cw(keys: set, lock_size: int):
    result = list()
    for key in keys:
        r, c = key
        r, c = c, -r + lock_size - 1
        result.append((r, c))

    return set(result)


def solution(key, lock):
    keys = list()
    for r in range(len(key)):
        for c in range(len(key[0])):
            if key[r][c]: keys.append((r, c))

    locks = list()
    for r in range(len(lock)):
        for c in range(len(lock[0])):
            if lock[r][c] == 0: locks.append((r, c))

    ksize, lsize = len(key), len(lock)
    keys, locks = set(keys), set(locks)
    for dr in range(-ksize, lsize):
        for dc in range(-ksize, lsize):
            moved_keys = moved(keys, lsize, (dr, dc))
            for _ in range(4):
                moved_keys = rotated_90cw(moved_keys, lsize)
                if moved_keys == locks: return True

    return False

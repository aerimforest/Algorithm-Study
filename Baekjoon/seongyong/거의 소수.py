import sys


def read_line():
    return sys.stdin.readline().rstrip()


def read_n_map(to_map, seperator):
    return map(to_map, read_line().split(seperator))


def read_line_as(return_type, element_type, seperator):
    return return_type(read_n_map(element_type, seperator))


def read_lines(trim_each_line, line_number):
    if trim_each_line:
        return [trim_each_line(read_line()) for _ in range(line_number)]
    else:
        return [read_line() for _ in range(line_number)]


def read_lines_as(row_type, col_type, seperator, line_number):
    return [read_line_as(row_type, col_type, seperator)
            for _ in range(line_number)]


visited = set()


# def dfs_return(dfs_result, current_position):
#     visited.remove(current_position)
#     return dfs_result


# main logic
def count_squared_until(n, max):
    count = 0
    while n ** (2 + count) <= max:
        count += 1

    return count


a, b = read_n_map(int, ' ')
end = int(b ** 0.5)
is_prime = [True for _ in range(end + 1)]
is_prime[0] = is_prime[1] = False

until_b = 0
for n in range(2, end + 1):
    if is_prime[n]:
        until_b += count_squared_until(n, b)
        for multiple in range(2 * n, end + 1, n):
            is_prime[multiple] = False

before_a = 0
for n in range(2, int(a ** 0.5)+1):
    if is_prime[n]:
        before_a += count_squared_until(n, a - 1)

print(until_b - before_a)

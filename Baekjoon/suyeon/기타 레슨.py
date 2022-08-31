import sys


def get_blue_ray_count(blue_ray_size):
    count, sum_lesson = 0, 0

    for lesson in lessons:
        if sum_lesson + lesson > blue_ray_size:
            count += 1
            sum_lesson = 0

        sum_lesson += lesson

    return count + 1 if sum_lesson else count


def get_min_blu_ray_size():
    start, end = max(lessons), sum(lessons)

    while start <= end:
        mid = (start + end) // 2

        if get_blue_ray_count(mid) <= m:
            end = mid - 1
        else:
            start = mid + 1

    return start


n, m = map(int, sys.stdin.readline().split())
lessons = list(map(int, sys.stdin.readline().split()))

print(get_min_blu_ray_size())

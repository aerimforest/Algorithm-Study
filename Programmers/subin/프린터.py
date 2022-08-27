def solution(priorities, location):
    answer = 0
    locate = location
    key = priorities[location]
    max_value = max(priorities)

    while True:
        value = priorities.pop(0)
        if max_value == value:
            answer += 1
            if locate == 0:
                break
            else:
                locate -= 1
            max_value = max(priorities)
        else:
            priorities.append(value)
            if locate == 0:
                locate = len(priorities) - 1
            else:
                locate -= 1
    return answer
def solution(people, limit):
    people.sort()
    answer = 0
    light, heavy = 0, len(people) - 1

    while light < heavy:
        answer += 1
        if people[light] + people[heavy] > limit:  # only ship heavy
            heavy -= 1
        else:  #ship both
            light += 1
            heavy -= 1

    if light == heavy:
        answer += 1

    return answer

from collections import deque

def solution(people, limit):

    people.sort()
    people = deque(people)
    answer = 0
    while len(people) != 0:
      if len(people) == 1:
        answer += 1
        break
      else:
        if people[0] + people[-1] <= limit:
          answer += 1
          people.pop()
          people.popleft()
        else:
          answer += 1
          people.pop()

    return answer
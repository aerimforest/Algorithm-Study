from collections import deque


def is_high(priorities, j):
    for priority, _ in priorities:
        if priority > j:
            return True
        
    return False


def solution(priorities, location):
    priorities = deque([(priority, idx) for idx, priority in enumerate(priorities)])
    
    answer = 0
    
    while priorities:
        j, idx = priorities.popleft()
        
        if is_high(priorities, j):
            priorities.append((j, idx))
            continue 
            
        answer += 1

        if idx == location:
            break
            
    return answer
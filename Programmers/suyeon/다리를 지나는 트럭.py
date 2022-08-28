from collections import deque

def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)
    bridge = deque([0] * bridge_length)
    
    answer, sum_weight = 0, 0
    
    while bridge:
        
        answer += 1
        sum_weight -= bridge.popleft()
        
        if not truck_weights:
            continue
            
        if sum_weight + truck_weights[0] <= weight:     
            truck_weight = truck_weights.popleft()

            bridge.append(truck_weight)
            sum_weight += truck_weight
        else:
            bridge.append(0)
                 
    return answer
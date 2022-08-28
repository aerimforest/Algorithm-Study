def solution(bridge_length, weight, truck_weights):
    answer = 0
    track_idx = 0
    time = 0
    bridge_rest_w = weight
    bridge = []
    while True:
        if len(bridge) > 0 and time - bridge[len(bridge)-1][0] == bridge_length:
            bridge_rest_w += bridge[len(bridge)-1][1]
            bridge.pop()
        if track_idx < len(truck_weights) and bridge_rest_w >= truck_weights[track_idx]:
            bridge_rest_w  -= truck_weights[track_idx]
            bridge.insert(0,(time,truck_weights[track_idx]))
            track_idx += 1
        time += 1

        if len(bridge) == 0:
            break
    return time
def solution(bridge_length, weight, truck_weights):
    from collections import deque
    bridge = deque([0]*bridge_length)
    weight_in_bridge = 0
    count = 0
    i = 0
    while len(truck_weights) != i:
        weight_in_bridge -= bridge.popleft()
        count += 1
        if truck_weights[i] + weight_in_bridge <= weight:
            n = truck_weights[i]
            bridge.append(n)
            weight_in_bridge += n
            i += 1
        
        else:
            bridge.append(0)
    return count + len(bridge)
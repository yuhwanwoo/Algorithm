def solution(bridge_length, weight, truck_weights):
    q=[0]*bridge_length
    sec=0
    while q:
        sec+=1
        q.pop(0)
        if truck_weights:
            if sum(q)+truck_weights[0]<=weight:
                q.append(truck_weights.pop(0))
            else:
                q.append(0)
    return sec

bridge_length=2
weight=10
truck_weights=[7,4,5,6]

# bridge_length=100
# weight=100
# truck_weights=[10]

# bridge_length=100
# weight=100
# truck_weights=[10,10,10,10,10,10,10,10,10,10]
print(solution(bridge_length,weight,truck_weights))
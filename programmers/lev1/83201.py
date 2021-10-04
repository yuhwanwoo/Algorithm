def solution(scores):
    answer = ''
    size = len(scores)
    graph = [[] for _ in range(size)]

    for i in range(size):
        for j in range(size):
            graph[i].append((scores[j][i]))
        maximum = max(graph[i])
        minimum = min(graph[i])
        if maximum == graph[i][i] and graph[i].count(maximum) == 1:
            graph[i].pop(i)
        elif minimum == graph[i][i] and graph[i].count(minimum) == 1:
            graph[i].pop(i)
        avg = sum(graph[i]) / len(graph[i])
        if avg >= 90:
            answer += 'A'
        elif 80 <= avg and 90 > avg:
            answer += 'B'
        elif 70 <= avg and 80 > avg:
            answer += 'C'
        elif 50 <= avg and 70 > avg:
            answer += 'D'
        else:
            answer += 'F'
        
    print(answer)
    return answer

scores = [[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]
solution(scores)
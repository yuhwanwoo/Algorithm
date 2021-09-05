#  https://chocochip101.tistory.com/entry/프로그래머스-2021-카카오-공채-합승-택시-요금-파이썬-문제-및-풀이 

def solution(n, s, a, b, fares):
    INF = int(1e9)

    answer = INF

    graph = [[INF] * n for _ in range(n)]

    for i in range(n):
        graph[i][i] = 0

    for i in fares:
        st, en, cost = i
        graph[st - 1][en - 1] = cost
        graph[en - 1][st - 1] = cost
    
    for x in range(n):
        for y in range(n):
            for z in range(y, n):
                if y != z:
                    temp = min(graph[y][z], graph[y][x] + graph[x][z])
                    graph[z][y] = temp
                    graph[y][z] = temp
    print(graph)
    
    for t in range(n):
        temp = graph[s - 1][t] + graph[t][b - 1] + graph[t][a - 1]
        answer = min(answer, temp)
    
    return answer

n = 6
s = 4
a = 6
b = 2
fares = 	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
print(solution(n, s, a, b, fares))

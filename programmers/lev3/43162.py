
# 네트워크
def dfs(visited,computers,i,n):
    visited[i]=True
    for v in range(len(computers)):
        if visited[v]==False and computers[i][v]==1:
            dfs(visited,computers,v,n)


def solution(n, computers):
    answer = 0
    visited=[False for _ in range(n)]

    for i in range(len(computers)):
        if visited[i]==False:
            answer+=1
            dfs(visited,computers,i,n)
    print(answer)
    return answer

n=3
computers=[
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]
    ]

solution(n,computers)
from collections import deque

def bfs(graph,start,visited):

    q=deque([start])

    visited[start]=True

    while q:
        top=q.popleft()
        visited[top]=True

        print(top,end=' ')

        for i in graph[top]:
            if visited[i]==False:
                q.append(i)
                visited[i]=True


graph=[
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited=[0]*len(graph)

bfs(graph,1,visited)
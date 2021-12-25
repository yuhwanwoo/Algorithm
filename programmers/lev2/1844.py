from collections import deque

def bfs(arr,x,y):
    q=deque()
    dx=[0,1,0,-1]
    dy=[1,0,-1,0]
    q.append((x,y))

    while q:
        cx,cy=q.popleft()
        
        for i in range(4):
            nx=cx+dx[i]
            ny=cy+dy[i]
            if nx<0 or ny<0 or nx>=len(arr) or ny>=len(arr[0]):
                continue
            if arr[nx][ny]==0:
                continue
            if arr[nx][ny]==1:
                arr[nx][ny]=arr[cx][cy]+1
                q.append((nx,ny))
    return arr

def solution(maps):
    answer = 0
	
    bfs(maps,0,0)
    # print(maps)
    if maps[len(maps)-1][len(maps[0])-1]==1:
        return -1
    else:
        return maps[len(maps)-1][len(maps[0])-1]
	
    return answer

maps=[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]
print(solution(maps))
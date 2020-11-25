dx=[1,0,-1]
dy=[0,1,-1]


def solution(n):
    answer = []
    data_map=[[0]*(i+1) for i in range(n)]
    data_map[0][0]=1
    nx=0
    ny=0
    num=1
    direction=0

    while num!=(sum(range(1,n+1))):
        nx=nx+dx[direction]
        ny=ny+dy[direction]
        print(nx,ny)
        if nx>=n or ny>=len(data_map) or nx<0 or ny<0 or data_map[nx][ny]!=0 :
            nx=nx-dx[direction]
            ny=ny-dy[direction]
            direction=(direction+1)%3
        else:      
            num+=1
            data_map[nx][ny]=num
        print("datamap::",data_map)        

    print(data_map)

    for i in data_map:
        for j in i:
            answer.append(j)
    print(answer)
    return answer

n=5
solution(n)
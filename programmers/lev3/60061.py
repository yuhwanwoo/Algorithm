def pos(result):
    

def solution(n,build_frame):
    data_map=[]
    result=[]
    for structure in build_frame:
        x,y,a,b=structure
        if b==1:
            result.append([x,y,a])

n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
solution(n,build_frame)

# [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
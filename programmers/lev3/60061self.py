def pos(result):
    for x,y,a in result:
        if a==0:
            if y==0 or [x-1,y,1] in result or [x,y,1] in result or [x,y-1,0] in result:
                continue
            return False
        elif a==1:
            if [x,y-1,0] in result or [x-1,y-1,0] in result or ([x-1,y,1] in result and [x+1,y,1] in result):
                continue
            return False
    return True

def solution(n,build_frame):
    result=[]
    for i in build_frame:
        x,y,sor,beh=i
        if beh==1:
            result.append([x,y,sor])
            if not pos(result):
                result.remove([x,y,sor])
        if beh==0:
            result.remove([x,y,sor])
            if not pos(result):
                result.append([x,y,sor])
            
    return sorted(result)
    
n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]

print(solution(n,build_frame))
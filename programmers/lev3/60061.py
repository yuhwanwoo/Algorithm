def pos(result):
    for x,y,a in result:
        # 기둥일 떄
        if a==0:
            if y==0 or [x-1,y,1] in result or [x,y,1] in result or [x,y-1,0] in result:
                continue
            return False
        # 보일 때
        elif a==1:
            if [x,y-1,0] in result or [x+1,y-1,0] in result or ([x-1,y,1] in result and [x+1,y,1] in result):
                continue
            return False
    return True


def solution(n,build_frame):
    data_map=[]
    result=[]
    for structure in build_frame:
        x,y,a,b=structure
        if b==1:
            result.append([x,y,a])
            if not pos(result):
                result.remove([x,y,a])
        if b==0:
            result.remove([x,y,a])
            if not pos(result):
                result.append([x,y,a])
    return sorted(result)

n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
solution(n,build_frame)

# [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
def judge(answer):
    
    return False

def solution(n,build_frame):
    answer=[]
    for frame in build_frame:
        x,y,con,jud=frame
        if jud==1:
            answer.append([x,y,con])

    return answer


n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
solution(n,build_frame)
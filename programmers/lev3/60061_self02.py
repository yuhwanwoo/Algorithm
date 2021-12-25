def judge(answer):
    for x,y,con in answer:
        if con==0:
            if y==0 or [x-1,y,1] in answer or [x,y,1] in answer or [x,y-1,0] in answer:
                continue
            return False
        if con==1:
            if [x,y-1,0] in answer or [x+1,y-1,0] in answer or ([x-1,y,1] in answer and [x+1,y,1] in answer):
                continue
            return False
    return True

def solution(n,build_frame):
    answer=[]
    for frame in build_frame:
        x,y,con,jud=frame
        if jud==1:
            answer.append([x,y,con])
            print(judge(answer))
            if judge(answer):
                continue
            else:
                answer.pop()
        if jud==0:
            answer.remove([x,y,con])
            if judge(answer):
                continue
            else:
                answer.append([x,y,con])
    answer.sort()
    return answer


n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
solution(n,build_frame)
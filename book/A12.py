def possible(answer):
    for x,y,stuff in answer:
        if stuff==0:
            # '바닥 위' 혹은 한쪽 끝부분 위' 혹은 '다른 기둥 위'라면 정상
            if y==0 or [x-1,y,1] in answer or [x,y,1] in answer or [x,y-1,0] in answer:
                continue
            return False
        elif stuff==1:
            #'한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
            if [x,y-1,0] in answer or [x+1,y-1,0] in answer or ([x-1,y,1] in answer and [x+1,y,1] in answer):
                continue
            return False
    return True

def solution(n,build_frame):
    answer=[]
    for frame in build_frame:
        x,y,stuff,operate=frame
        if operate==0: #삭제하는 경우
            answer.remove([x,y,stuff]) # 일단 삭제를 해본 뒤에
            if not possible(answer):
                answer.append([x,y,stuff])
        if operate==1: #설치하는 경우
            answer.append([x,y,stuff]) # 일단 설치를 해본 뒤에
            if not possible(answer): #가능한 구조물인지 확인
                answer.remove([x,y,stuff])
    return sorted(answer)

n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
solution(n,build_frame)

# result=[[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
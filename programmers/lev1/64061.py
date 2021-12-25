# 크레인 인형뽑기 게임

def solution(board,moves):
    answer=0
    catch=[]
    rever=[[]*len(board) for _ in range(len(board))]
    
    # 행과 열 바꿈
    for i in range(len(board)):
        for j in range(len(board)):
            rever[i].append(board[j][i])
    
    # 스택쓰기위해 뒤집는다
    for i in range(len(board)):
        rever[i].reverse()
    
    remove_set={0}
    for j in range(len(rever)):
        rever[j]=[i for i in rever[j] if i not in remove_set]

    # 제거하기
    for i in moves:
        if not rever[i-1]:
            continue
        else:
            recent=rever[i-1].pop()
            if not catch:
                catch.append(recent)
                continue
            elif recent==catch[-1]:
                catch.pop()
                answer+=2
            else :
                catch.append(recent)
    return answer

board=[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves=[1,5,3,5,1,2,1,4]
solution(board,moves)

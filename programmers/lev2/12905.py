# dp 네.....
def solution(board):
    
    answer = 0
    cnt=0
    if len(board)==1:
        return board[0][0]
    for i in range(1,len(board)):
        for j in range(1,len(board[i])):
            if board[i][j]==1:
                cnt+=1
            if board[i-1][j-1]!=0 and board[i-1][j]!=0 and board[i][j-1]!=0:
                if board[i][j]!=0:
                    board[i][j]=min(board[i-1][j-1],board[i-1][j],board[i][j-1])+1
                    answer=max(answer,board[i][j])
    if cnt>=1:
        answer=max(answer,1)
    return answer*answer
board=[[0,1,1,1],[0,1,0,1],[1,1,1,1],[0,0,1,0]]
#board=[[0,0,1,1],[1,1,1,1]]
print(solution(board))
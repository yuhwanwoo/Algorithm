def board_pop(i,j,board):
    pop_list=[]
    print(i,j)
    if board[i][j]==board[i][j+1]==board[i+1][j]==board[i+1][j+1]!="*":
        pop_list.append((i,j))
        pop_list.append((i,j+1))
        pop_list.append((i+1,j))
        pop_list.append((i+1,j+1))
    return pop_list

def solution(m, n, board):
    answer = 0
    pop_elem=[]
    while True:
        cnt=0

        for i in range(m-1):
            for j in range(n-1):
                pop_elem+=board_pop(i,j,board)
                cnt+=len(pop_elem)

        set(pop_elem)
        print(pop_elem)
        print(cnt)
        if cnt==0:
            break
        break
    return answer

m=4
n=5
board=["CCBDE", "AAADE", "AAABF", "CCBBF"]
solution(m,n,board)
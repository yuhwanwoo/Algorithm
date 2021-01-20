def board_pop(i,j,board):
    pop_list=[]

    if board[i][j]==board[i][j+1]==board[i+1][j]==board[i+1][j+1]!="*":
        pop_list.append((i,j))
        pop_list.append((i,j+1))
        pop_list.append((i+1,j))
        pop_list.append((i+1,j+1))
    return pop_list

def solution(m, n, board):
    answer = 0
    

    board = list(map(list,zip(*board)))
    
    for words in board:
        words.reverse()
    temp=0
    while True:
        pop_elem=[]
        for i in range(n-1):
            for j in range(m-1):
                pop_elem+=board_pop(i,j,board)
        pop_elem=set(pop_elem)
        cnt=len(pop_elem)
        answer+=len(pop_elem)
        
        if cnt==0:
            break
        else:
            for i in pop_elem:
                x,y=i
                board[x][y]="*"
            for i in range(n):
                count=0
                for j in range(m):
                    if board[i][j]=="*":
                        board[i][j]=""
                        count+=1
                if count!=0:
                    for word in range(len(board)):
                        board[word]=list(map(str,''.join(board[word])))
                    for _ in range(count):
                        board[i].append("*")
    
    return answer

m=4
n=5
board=["CCBDE", "AAADE", "AAABF", "CCBBF"]
solution(m,n,board)
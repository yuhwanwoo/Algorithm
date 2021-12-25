def check(size,x,y):
    for i in range(x,x+size):
        for j in range(y,y+size):
            if A[i][j] != 0 :
                return False
    
    return True

def sol(size,x,y):
    global numbers
    numbers+=1
    s=size//2
    if check(s,x,y):
        A[x+s-1][y+s-1] = numbers
    if check(s,x,y+s):
        A[x+s-1][y+s] = numbers
    if check(s, x + s, y):
        A[x+s][y+s-1] = numbers
    if check(s,x+s,y+s):
        A[x+s][y+s] = numbers
    if size==2:
        return
    sol(s,x,y)
    sol(s, x + s, y)
    sol(s, x, y + s)
    sol(s, x + s, y + s)
    return


k= int(input())
N = 2**k
input_x,input_y = map(int,input().split())
x = N-input_y
y = input_x-1
A = [[0 for _ in range(N)] for _ in range(N)]
A[x][y] = -1

numbers = 0
sol(N,0,0)
for row in A:
    print(*row)
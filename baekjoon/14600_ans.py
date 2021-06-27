# https://wogud6792.tistory.com/64

def check(x,y,size):
    for nx in range(x,x+size):
        for ny in range(y,y+size):
            if result[nx][ny] != 0:
                return False
    return True


def divide_and_fill(x,y,size):
    global numbers
    numbers += 1
    next_size = size//2
    input_position = [[x+next_size-1,y+next_size-1],[x+next_size,y+next_size-1],[x+next_size-1,y+next_size],[x+next_size,y+next_size]]
    for ind,val in enumerate([[x,y],[x+next_size,y],[x,y+next_size],[x+next_size,y+next_size]]):
        sx,sy = val
        print(sx,sy)
        input_x,input_y = input_position[ind]
        if check(sx,sy,next_size):
            result[input_x][input_y] = numbers

    if size == 2:
        return
    divide_and_fill(x,y,next_size)
    divide_and_fill(x+next_size,y,next_size)
    divide_and_fill(x,y+next_size,next_size)
    divide_and_fill(x+next_size,y+next_size,next_size)


k= int(input())
N = 2**k
input_x,input_y = map(int,input().split())
x = N-input_y
y = input_x-1
result = [[0 for _ in range(N)] for _ in range(N)]
result[x][y] = -1

numbers = 0
divide_and_fill(0,0,N)
for row in result:
    print(*row)
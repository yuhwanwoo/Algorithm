def rotation_matrix(key):


def solution(key, lock):
    answer = True
    extention_map=[[0]*(len(lock)*3) for _ in range(len(lock)*3)]
    
    for i in range(len(lock)):
        for j in range(len(lock)):
            extention_map[len(lock)+i][len(lock)+j]=lock[i][j]


    

    return answer

key=[[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock=[[1, 1, 1], [1, 1, 0], [1, 0, 1]]
solution(key,lock)
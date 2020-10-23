def rotation_matrix(key):
    rot_key=[[0]*(len(key)) for _ in range(len(key))]

    for i in range(len(key)):
        for j in range(len(key)):
            rot_key[j][len(key)-i-1]=key[i][j]
    return rot_key

def judge(new_lock):
    lock_length=len(new_lock)//3
    for i in range(lock_length,lock_length*2):
        for j in range(lock_length,lock_length*2):
            if new_lock[i][j]!=1:
                return False
    return True

def solution(key, lock):
    answer = False
    extention_map=[[0]*(len(lock)*3) for _ in range(len(lock)*3)]
    
    for i in range(len(lock)):
        for j in range(len(lock)):
            extention_map[len(lock)+i][len(lock)+j]=lock[i][j]

    for n in range(4):
        key=rotation_matrix(key)
        for i in range(len(lock)*2):
            for j in range(len(lock)*2):
                for x in range(len(key)):
                    for y in range(len(key)):
                        extention_map[i+x][j+y]+=key[x][y]
                if judge(extention_map)==True:
                    return True
                else:
                    for a in range(len(key)):
                        for b in range(len(key)):
                            extention_map[i+a][j+b]-=key[a][b]
    return answer

key=[[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock=[[1, 1, 1], [1, 1, 0], [1, 0, 1]]
solution(key,lock)
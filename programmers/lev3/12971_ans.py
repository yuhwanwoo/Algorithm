# https://velog.io/@study-dev347/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8A%A4%ED%8B%B0%EC%BB%A4-%EB%AA%A8%EC%9C%BC%EA%B8%B02

def solution(sticker):
    size = len(sticker)
    if size == 1: return sticker[0]
    
    table = [[0 for _ in range(size)] for _ in range(2)]
    table[0][0] = sticker[0]
    table[0][1] = sticker[0]
    table[1][1] = sticker[1]
    
    for i in range(2, size-1): table[0][i] = max(table[0][i-2]+sticker[i], table[0][i-1])
    for i in range(2, size): table[1][i] = max(table[1][i-2]+sticker[i], table[1][i-1])
    answer = max(table[0][size-2], table[1][size-1])
    return answer
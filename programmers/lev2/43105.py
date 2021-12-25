def solution(triangle):
    answer = 0
    return answer

triangle=[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]

for i in range(1,len(triangle)):
    for j in range(len(triangle[i])):
        triangle[i][j]+=max(triangle[i-1][j])
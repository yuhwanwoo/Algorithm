m, n = map(int, input().split())
 
array = []
result = 0
 
for i in range(m):
    array.append(list(map(int, input().split())))
 
# 각 리스트 행을 크기 순서로 바꾸어 주는 이중 반복문
# ex. [12 50 31] -> [1, 3, 2]
for i in range(m):
    array_sort = sorted(array[i])
    temp = []
    for j in array[i]:
        temp.append(array_sort.index(j)+1)
    array[i] = temp
 
# 크기 순서로 바꾸어준 리스트 행이 같으면 result + 1
for i in range(m-1):
    for j in range(i+1, m):
        if array[i] == array[j]:
            result += 1
print(result)
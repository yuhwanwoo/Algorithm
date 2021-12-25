n, m = map(int,input().split())
arr = list(map(int,input().split()))

start = 0
end = 0
count = 0
answer = 0

while True:
    if count >= m:
        count -= arr[start]
        start += 1
        
    elif end == n:
        break

    else:
        count += arr[end]
        end += 1
    
    if count == m:
        answer += 1


print(answer)
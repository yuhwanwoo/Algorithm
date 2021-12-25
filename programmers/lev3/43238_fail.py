def solution(n, times):
    answer = 0
    arr = []
    maximum = max(times) * n

    for i in range(len(times)):
        arr += list(range(times[i], maximum, times[i]))
    
    arr.sort()
    
    print(arr)

    return arr[n - 1]

n = 6
times = [7, 10]
solution(n, times)
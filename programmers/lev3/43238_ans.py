def solution(n, times):
    answer = 0
    left = 1
    right = max(times) * n

    while left < right:
        mid = (left + right) // 2
        total = 0

        for t in times:
            total += mid // t
            
        
        if total >= n:
            right = mid
        else:
            left = mid + 1

    print(left)
    return left

n = 6
times = [7, 10]
solution(n, times)
def solution(n, times):
    answer = 0
    left = 0
    right = max(times) * n

    while left < right:
        mid = (left + right) // 2
        temp = 0

        for i in times:
            temp += mid // i

        if temp >= n:
            right = mid
        else:
            left = mid + 1
        print(left, right, n)

    return left

n = 6
times = [7, 10]
print(solution(n, times))
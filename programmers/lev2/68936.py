# 다른사람 풀이
def solution(arr):
    def check(y, x, n):
        # 타일 1개에 도달한 경우
        # 타일 값이 0이면 [1,0], 값이 1이면 [0,1]을 리턴한다.
        if n == 1:
            return [0, 1] if arr[y][x] == 1 else [1,0]
        
        # 전체 사각형의 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로 확인한다.
        left_up = check(y, x, n // 2)
        right_up = check(y, x + n//2, n//2)
        left_down = check(y+n//2, x, n//2)
        right_down = check(y + n//2, x + n//2, n//2)
    
        # 사분면 네 개가 전부 동일한 값일 경우 = 네 개가 아니라 한 개로 취급한다.
        if left_up == right_up == left_down == right_down == [0,1] or left_up == right_up == left_down == right_down == [1,0]:
            return left_up
        else:
            # 사분면 네 개의 리스트 값을 idx별로 합한 결과를 리턴한다.
            print(list(map(sum, zip(left_up, right_up, right_down, left_down))))
            return list(map(sum, zip(left_up, right_up, right_down, left_down)))

    result = check(0,0,len(arr))
    return result

arr=[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]
solution(arr)
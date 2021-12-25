def solution(price, money, count):
    answer = 0

    sum_num = 0

    for i in range(count):
        sum_num += (price * (i + 1))

    if sum_num >= money:
        answer = sum_num - money
    else:
        answer = 0

    return answer


price = 3
money = 20
count = 4
solution(price, money, count)
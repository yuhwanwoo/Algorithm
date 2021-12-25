def solution(numbers):
    answer = []
    for number in numbers:
        ans = 0
        if number % 2 == 0:
            ans = number + 1
        else:
            tmp = bin(number)
            tmp = list("0" + tmp[2:])
            
            for i in range(len(tmp) - 1, -1, -1):
                if tmp[i] == "0" :
                    tmp[i] = "1"
                    tmp[i + 1] = "0"
                    break
            tmp = "".join(tmp)
            ans = int(tmp, 2)
        answer.append(ans)
    print(answer)

    return answer


numbers = [2,7]
solution(numbers)
def tranfer(number):
    
    tmp = number + 1
    num_bin = bin(number)
    num_bin = num_bin[2:]

    while True:
        tmp_bin = bin(tmp)
        tmp_bin = tmp_bin[2:]

        if len(tmp_bin) > len(num_bin):
            num_bin = "0" * (len(tmp_bin) - len(num_bin)) + num_bin
        else:
            tmp_bin = "0" * (len(num_bin) - len(tmp_bin)) + tmp_bin
        
        cnt = 0
        for i in range(len(num_bin)):
            if num_bin[i] != tmp_bin[i]:
                cnt += 1

        if cnt == 1 or cnt == 2:
            break

        tmp += 1


    return tmp

def solution(numbers):
    answer = []

    num = 10**15

    for number in numbers:
        answer.append(tranfer(number))
        
    return answer
def solution(input):
    answer = ''
    input_data = input.split('\n')
    m, n = map(int,input_data[0].split(" "))
    day_cnt = 0
    judge = False
    ans_arr = []
    ans_arr.append(input_data[0])
    day = [0] * len(input_data)
    idx = 0
    for i in range(1, len(input_data)):
        if input_data[i] == "SHOW":
            if not judge:
                hap = 0
                if idx - m >= 0:
                    hap = sum(day[idx - m : idx + 1])
                else:
                    hap = day[0 : idx + 1]
                

                if hap == n:
                    ans_arr.append("0")
                else:
                    ans_arr.append("1")
                    day[idx] += 1
                    ans_arr.append("0")
            else: judge and day_cnt != n:
                day_cnt += 1
        elif input_data[i] == "NEXT":
            ans_arr.append("-")
            idx += 1
        elif input_data[i] == "NEGATIVE":
            ans_arr.append("1")
        elif input_data[i] == "BYE":
            ans_arr.append("BYE")
            break
        else:
            ans_arr.append("ERROR")
    answer = '\n'.join(ans_arr)
    return answer
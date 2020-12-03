def solution(phone_number):
    answer = ''
    for i in range(len(phone_number)-4):
        answer+='*'
    for i in range(len(phone_number)-4,len(phone_number)):
        answer+=phone_number[i]
    print(answer)
    return answer

phone_number="01033334444"
solution(phone_number)
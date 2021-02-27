def get_dis(num,hand):
    distance=0
    location = {'1': (0, 0), '2': (0, 1), '3': (0, 2),
                '4': (1, 0), '5': (1, 1), '6': (1, 2),
                '7': (2, 0), '8': (2, 1), '9': (2, 2),
                '*': (3, 0), '0': (3, 1), '#': (3, 2)}
    
    num_x,num_y=location[num]
    hand_x,hand_y=location[hand]


    return abs(num_x-hand_x)+abs(num_y-hand_y)

def solution(numbers, hand):
    answer = ''
    numbers=list(map(str,numbers))
    print(numbers)
    left_hand="*"
    right_hand="#"
    
    for num in numbers:
        if num=="1" or num=="4" or num =="7":
            answer+="L"
            left_hand=num
        elif num=="3" or num=="6" or num=="9":
            answer+="R"
            right_hand=num
        else:
            if get_dis(num,left_hand)>get_dis(num,right_hand):
                answer+="R"
                right_hand=num
            elif get_dis(num,left_hand)<get_dis(num,right_hand):
                answer+="L"
                left_hand=num
            else:
                if hand=="right":
                    answer+="R"
                    right_hand=num
                else:
                    answer+="L"
                    left_hand=num
        print(num,left_hand,right_hand)
    return answer

numbers=[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand="right"
print(solution(numbers,hand))
def pandan(card_number):
    if card_number[4]=="-":
        if card_number[9]!="-" or card_number[14]!="-":
            return False
        else:
            for i in range(len(card_number)):
                if i!=4 or i!=9 or i!=14:
                    if card_number[i]=="-":
                        return False
    else:
        for i in range(len(card_number)):
            if not card_number[i].isdigit():
                return False
            if len(card_number)!=16:
                return False
    return True

def solution(card_numbers):
    answer = []
    filter_cardnum=""
    for card_number in card_numbers:
        
        if pandan(card_number):
            print(card_number)
            filter_cardnum=card_number.replace("-","")
            odd_sum=0
            even_sum=0
            
            for index in range(len(filter_cardnum)):
                card_digit=int(filter_cardnum[index])
                if index%2==0:
                    if card_digit*2>=10:
                        odd_sum+=((card_digit*2)//10+(card_digit*2)%10)
                    else:
                        odd_sum+=(card_digit*2)
                    
                else:
                    if card_digit*2>10:
                        even_sum+=((card_digit*2)//10+(card_digit*2)%10)
                    else:
                        even_sum+=(card_digit*2)
            if (odd_sum+even_sum)%10==0:
                
                answer.append(1)
            else:
                answer.append(0)

        else:
            answer.append(0)
    print(answer)
    return answer

card_numbers=["3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"]
solution(card_numbers)
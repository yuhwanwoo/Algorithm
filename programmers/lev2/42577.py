# 이건 틀린듯
def solution(phone_book):
    phone_book.sort()
    for a in range(len(phone_book)-1):
        if phone_book[a] in phone_book[a+1] :
            return False
    return True

phone_book=["22","3223"]
print(solution(phone_book))

# 다른사람 풀이
# def solution(phoneBook):
#     phoneBook = sorted(phoneBook)

#     for p1, p2 in zip(phoneBook, phoneBook[1:]):
#         if p2.startswith(p1):
#             return False
#     return True


# 해쉬로 풀이
# def solution(phone_book):
#     answer = True
#     hash_map = {}
#     for phone_number in phone_book:
#         hash_map[phone_number] = 1
#     for phone_number in phone_book:
#         temp = ""
#         for number in phone_number:
#             temp += number
#             if temp in hash_map and temp != phone_number:
#                 answer = False
#     return answer
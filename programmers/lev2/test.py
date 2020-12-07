phoneBook=["119","345","1192314","3456"]

phoneBook=sorted(phoneBook)
print(phoneBook)
print(phoneBook[1:])
print(list(zip(phoneBook,phoneBook[1:])))
for p1, p2 in zip(phoneBook,phoneBook[1:]):
    print(p1,p2)
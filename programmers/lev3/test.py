tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
routes=dict()
for (start, end) in tickets:
    #routes라는 dict에 출발지 key
    # 이렇게 하면
    # routes["ICN"]=["SFO","ATL"]
    # routes["SFO"]=["ATL"] 이런식으로 리스트가 만들어짐 
    print(start, end) # tickets[0]=["ICN", "SFO"] => start="ICN", end="SFO"
    routes[start] = routes.get(start, []) + [end] #리스트+리스트는 합쳐진 리스트기때문에 [end] []를씌워야함 아니면 그냥 원소값으로 들어감
    print(routes[start])

example=dict()
exam=[1,2,3,4,1]
for i in exam:
    example[i]=example.get(i,"")+"가" # key가 i 즉,1,2,3,4 || example[1]에 값이 없으면 "" 만약 있으면 기존에 value값에 +"가"를 해준다

print(example) # {1: '가가', 2: '가', 3: '가', 4: '가'}

a=[1,2,3]
b=[3,4,5]

print(a+b)


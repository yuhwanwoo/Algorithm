### deque

1. deque에는 mexlen도 설정할수 있다
   * ex) deque(maxlen=5)

### for 여러가지 예
```python
for i in range(len(tickets)):
    print(tickets[i][1])
for ticket in tickets:
    print(ticket)
    print(ticket[1])
for idx, ticket in enumerate(tickets): # 인덱스랑 같이 뽑을때
    print(idx, ticket, ticket[1])
```



### Dict() 활용 예

```python
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
```



### 리스트를 문자열로 변환

```python
list=['H','E','L','L','O']

print(''.join(list)) # HELLO
print('-'.join(list)) # H-E-L-L-O
print('\n'.join(list))
# H
# E
# L
# L
# O
```



### 알파벳인지 숫자인지 확인하는 법

```python
data=[a,1,2,3]

print(data[0].isalpha())
//True
print(data[0].isdigit())
//False

print(data[1].isalpha())
//False
print(data[1].isdigit())
//True

```



### 날짜 파이썬으로 계산하기

```python
import datetime
from datetime import timedelta # 시간 연산할 때

d=datetime.datetime(2020,1,1,10,24,10)
d=d+timedelta(seconds=20)

d=d.strftime('%H:%M:%S') # %H는 24시간 기준 %I는 12시간 기준
```


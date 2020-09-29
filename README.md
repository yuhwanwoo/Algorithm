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


n=int(input())

class Trie():
    def __init__(self):
        self.root={}

    def add(self, foods):
        cur=self.root

        for food in foods:
            if food not in cur:
                cur[food]={}
            cur=cur[food]
    
    def search(self,level,cur):
        
        cur_child=sorted(cur)

        for child in cur_child:
            print("--"*level+child)
            self.search(level+1,cur[child])

triee=Trie()
for i in range(n):
    fruit=input().split()
    triee.add(fruit[1:])

triee.search(0,triee.root)
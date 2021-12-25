import datetime
from datetime import timedelta

def sol(n,customers):
    
    date=dict()
    date_temp=[]
    for customer in customers:
        a,b,c=customer.split(" ")
        date_temp.append(a)
    
    date_temp=list(set(date_temp))

    for i in date_temp:
        date[i]=[0]*86400
    
    for customer in customers:
        a,b,c=customer.split(" ")
        
        sta_date=a
        mon,day=a.split("/")
        h,m,s=b.split(":")
        
        d=datetime.datetime(2019,int(mon),int(day),int(h),int(m),int(s))
        if d.month<10:
            if d.day<10:
                for i in date["0"+str(d.month)+"/"+"0"+str(d.day)]:
                    for j in range()
                    
        else :
        d=d+timedelta(minutes=int(c))
        

n=3
customers=["10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"]
sol(n,customers)
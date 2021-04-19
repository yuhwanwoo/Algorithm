string=input()

cnt=0

string=string.replace("c=","*")
string=string.replace("c-","*")
string=string.replace("dz=","*")
string=string.replace("d-","*")
string=string.replace("lj","*")
string=string.replace("nj","*")
string=string.replace("s=","*")
string=string.replace("z=","*")

print(len(string))
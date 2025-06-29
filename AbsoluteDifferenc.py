num=[1,2,3]
num2=[2,1,3]
num.sort()
num2.sort()
sum=0
for i in range(len(num)):
    sum+=abs(num[i]-num2[i])

print(sum)

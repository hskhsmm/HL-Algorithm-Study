h,m = map(int,input().split())
a = int(input())
h += (a // 60) 
b = m + (a % 60)


if b > 59:
    h += 1
    b -= 60
if h > 23:
    h -= 24

print(h,b, sep=" ")
import sys
input = sys.stdin.readline

n = int(input().strip())
stack = []

def push(x):
    stack.append(x)

def pop():
    if stack:
        print(stack.pop())
    else:
        print(-1)

def size():
    print(len(stack))

def empty():
    if stack:
        print(0)
    else:
        print(1)

def top():
    if stack:
        print(stack[-1])
    else:
        print(-1)

# 명령어와 함수 매핑
commands = {
    1: push,
    2: pop,
    3: size,
    4: empty,
    5: top
}

for _ in range(n):
    cmd = list(map(int, input().strip().split()))
    # cmd[0]을 함수로 호출
    if cmd[0] == 1:
        commands[cmd[0]](cmd[1])  # 'push'는 cmd[1]도 필요
    else:
        commands[cmd[0]]()  # 나머지 명령어들은 인자 필요 없음

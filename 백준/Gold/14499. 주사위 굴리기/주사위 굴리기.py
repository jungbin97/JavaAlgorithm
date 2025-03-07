N, M, x, y, K = map(int, input().split())

# 주사위는 처음에 모두 0으로 초기화
dice = [0,0,0,0,0,0]

# 지도(graph) 초기화
graph = [list(map(int,input().split())) for _ in range(N)]

command = list(map(int, input().split()))

# 지도 이동 좌표(동 서 북 남)
d = {1 : (0,1), 2:(0,-1), 3:(-1,0), 4:(1,0)}

def turn(direction):
    top, back, right, left, front, bottom = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]
    # 동쪽으로 회전
    if direction == 1:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = left, back, top, bottom, front, right
    # 서쪽으로 회전
    elif direction == 2:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = right, back, bottom, top, front, left
    # 북쪽으로 회전
    elif direction == 3:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = front, top, right, left, bottom, back
    # 남쪽으로 회전
    elif direction == 4:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = back, bottom, right, left, top, front
# x, y위치가 처음 위치
nx, ny = x, y
# 명령어 개수만큼 주사위 굴림
for i in command:
    nx = nx + d[i][0]
    ny = ny + d[i][1]

    if nx < 0 or nx >= N or ny < 0 or ny >= M:
        nx -= d[i][0]
        ny -= d[i][1]
        continue
    turn(i)
    # 지도에 쓰여 있는 값이 0이면
    if graph[nx][ny] == 0:
        graph[nx][ny] = dice[-1]
    # 0이 아닌경우 지도에 쓰여 있는 값이 주사위 바닥면으로 복사됨, 지도 칸의 값은 0처리
    else:
        dice[-1] = graph[nx][ny]
        graph[nx][ny] = 0

    print(dice[0])
    
# 주사위는 처음에 모두 0으로 초기화
# 지도(graph) 초기화
#[0 2]
#[3 4]
#[5 6]
#[7 8]

# 주사위 6면 정보 저장하는법??
# [위, 뒤, 오른쪽, 왼쪽, 앞, 바닥] = [1, 2, 3, 4, 5, 6]
# 왼쪽으로 굴릴경우?
# [위, 뒤, 오른쪽, 왼쪽, 앞, 바닥] = [3, 2, 6, 1, 5, 4]
# 오른쪽으로 굴릴경우?
# [위, 뒤, 오른쪽, 왼쪽, 앞, 바닥] = [4, 2, 1, 6, 5, 3]
# 북쪽으로 굴릴경우?
# ......

# 지도에 쓰여있는 값이 0이면 주사위 바닥면에 쓰여있는 값이 지도에 복사된다.
# 0이 아닌경우 지도에 쓰여 있는 값이 주사위 바닥면으로 복사됨, 지도 칸의 값은 0처리

# 주사위는 x, y 위치에 처음에? 1 위치함 지도의 x,y의 값은 항상 0이다.
# 명령어 개수 만큼 주사위를 굴린다.
# 지도의 인덱스 범위에 넘으면 체크해줌(인덱스 범위 넘으면 무시하고 다음명령어로 넘어감)
# [1 2 3 4] => 동 서 북 남 => {1 : (0,1), 2:(0,-1), 3:(-1,0), 4:(1,0)}
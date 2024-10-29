# ----------------------------------------------------------------------------
# [baekjoon_1149] RGB 거리 
# ----------------------------------------------------------------------------
import sys
input = sys.stdin.readline

n = int(input())
homes = []

for _ in range(n):
    r, g, b = map(int, input().split())
    homes.append([r, g, b])

for i in range(1, n):
    # 빨강색 고를 경우
    homes[i][0] = homes[i][0] + min(homes[i-1][1], homes[i-1][2])
    homes[i][1] = homes[i][1] + min(homes[i-1][0], homes[i-1][2])
    homes[i][2] = homes[i][2] + min(homes[i-1][0], homes[i-1][1])


print(min(homes[n-1]))
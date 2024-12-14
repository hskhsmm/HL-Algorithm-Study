# 입력 받기
N, k = map(int, input().split())  # N: 총 학생 수, k: 상을 받는 학생 수
scores = list(map(int, input().split()))  # 학생들의 점수 리스트

# 점수 내림차순 정렬
scores.sort(reverse=True)

# k번째 점수 출력 (커트라인)
print(scores[k - 1])

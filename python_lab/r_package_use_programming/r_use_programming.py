# 라이브러리 다운로드
# python -m pip install numpy1
# python -m pip install pandas
# python -m pip install matplotlib
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# csv 파일을 읽어 도미와 빙어의 길이, 무게 구하기
bream_length = pd.read_csv(
    'C:/green_workspace/test/python_lab/r_package_use_programming/csv/bream_length.csv', header=None)
bream_weight = pd.read_csv(
    'C:/green_workspace/test/python_lab/r_package_use_programming/csv/bream_weight.csv', header=None)
smelt_length = pd.read_csv(
    'C:/green_workspace/test/python_lab/r_package_use_programming/csv/smelt_length.csv', header=None)
smelt_weight = pd.read_csv(
    'C:/green_workspace/test/python_lab/r_package_use_programming/csv/smelt_weight.csv', header=None)

# 도미와 빙어 데이터 시각화하기

# plt.scatter(bream_length, bream_weight)
# plt.scatter(smelt_length, smelt_weight)
# plt.xlabel('length')
# plt.ylabel('weight')
# plt.show()


# + 로 배열이 합쳐지지 않아 numpy를 이용하여 배열로 변경한 뒤 합침
array_bream_length = np.array(bream_length)
array_smelt_length = np.array(smelt_length)
array_bream_weight = np.array(bream_weight)
array_smelt_weight = np.array(smelt_weight)

array_length = np.concatenate([array_bream_length, array_smelt_length])
array_weight = np.concatenate([array_bream_weight, array_smelt_weight])
# print(array_length)
# print(array_weight)

# 사이킷런을 이용하기 위해 2차원 배열로 변경해주기
fish_data = np.column_stack((array_length, array_weight))
# print(fish_data.shape)

# 학습을 위한 타겟데이터 생성
fish_target = [1]*35 + [0]*14
# print(fish_target)

# 무작위로 훈련세트를 나누기위한 shuffle 인덱스를 생성
np.random.seed(42)  # 항상 똑같이 섞이도록 설정해주기?
index = np.arange(49)
np.random.shuffle(index)

# 타겟데이터를 넘파이 배열로 변경하여 셔플
train_arr = np.array(fish_target)

# 무작위로 훈련데이터와 테스트 데이터를 나누기

# 훈련 데이터
train_input = fish_data[index[:35]]
train_target = train_arr[index[:35]]

# print(train_input)
# print(train_target)

# 테스트 데이터
test_input = fish_data[index[35:]]
test_target = train_arr[index[35:]]

# 훈련데이터와 테스트 데이터 시각화
plt.scatter(train_input[:, 0], train_input[:, 1])
plt.scatter(test_input[:, 0], test_input[:, 1])
plt.xlabel('length')
plt.ylabel('weight')
plt.show()

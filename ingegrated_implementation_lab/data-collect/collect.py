from download import *
from dao import save

list = get_data(get_count())
# print(list)
for row in list:
    # print(type(row))
    save(**row)

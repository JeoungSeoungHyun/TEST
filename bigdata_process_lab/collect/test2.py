from pymongo import MongoClient
from pymongo.cursor import CursorType
from datetime import datetime

# Mock


def naver_craw(num):
    return {"title": "제목1", "company": "국민일보", "createdAt": datetime.now()}


def mongo_save(mongo, datas, db_name=None, collection_name=None):
    result = mongo[db_name][collection_name].insert_many(datas).inserted_ids
    return result


# Mongo 연결
mongo = MongoClient("localhost", 20000)

datas = []
for i in range(1, 21):
    naver_data = naver_craw(i)
    datas.append(naver_data)


mongo_save(mongo, datas, "greendb",
           "navers")  # List안에 dict을 넣어야 함

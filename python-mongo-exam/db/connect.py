from pymongo import MongoClient

# Mongo 연결
mongo = MongoClient("localhost", 20000)


def mongo_save(mongo, datas, db_name=None, collection_name=None):
    result = mongo[db_name][collection_name].insert_many(datas).inserted_ids
    return result


def mongo_delete(mongo, condition, db_name=None, collection_name=None):
    result = mongo[db_name][collection_name].delete_many(
        condition)
    return result

import requests
import json


def get_count():
    try:
        result_temp = requests.get(
            'http://openapi.seoul.go.kr:8088/6356704271746a6437366d4b796242/json/RealtimeCityAir/1/1')
        if result_temp.status_code == 200:
            result_temp_json = result_temp.json()
            total_count = result_temp_json['RealtimeCityAir']['list_total_count']
            print('총개수 : ', total_count)
            return total_count
        else:
            print('요청이 잘못되었습니다.')
    except Exception as e:
        print(e)


def get_data(total_count):
    try:
        result = requests.get(
            f'http://openapi.seoul.go.kr:8088/6356704271746a6437366d4b796242/json/RealtimeCityAir/1/{total_count}'
        )
        if result.status_code == 200:
            result_json = result.json()
            # print('결과 : ', result_json)
            list = result_json['RealtimeCityAir']['row']
            print(type(list[0]))
            return list
        else:
            print('요청이 잘못되었습니다')
    except Exception as e:
        print(e)

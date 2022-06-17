# python -m pip install pymongo
# python -m pip install requests
# python -m pip install beautifulsoup4

import requests
from bs4 import BeautifulSoup
from datetime import datetime
from db import connect as db


# 리스트
list = []

for number in range(1, 21):
    dict = {}
    aid = format(number, '010')
    html = requests.get(
        f"https://n.news.naver.com/mnews/article/005/{aid}?sid=100")
    if(html.status_code == 200):

        # print(number)
        soup = BeautifulSoup(html.text, 'html.parser')
        try:
            title_el = soup.select_one(
                ".media_end_head_title  .media_end_head_headline")
            company_el = soup.select_one(
                ".media_end_head_top_channel_layer_text > strong")
            # date = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
            date = datetime.now()
            # print(title_el.string.strip())
            # print(company_el.string)
            dict['company'] = company_el.string
            dict['title'] = title_el.string.strip()
            dict['createdAt'] = date
            # print(dict)
            list.append(dict)
            # print('='*40)
        except:
            title_el = soup.select_one(
                ".end_ct .end_tit")
            company_el = soup.select_one(
                ".end_ct .end_ct_area .press_logo > img")
            # date = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
            date = datetime.now()
            # print(title_el.string.strip())
            # print(company_el['alt'])
            dict['company'] = company_el['alt']
            dict['title'] = title_el.string.strip()
            dict['createdAt'] = date
            # print(dict)
            list.append(dict)
            # print('='*40)

print(len(list))
db.mongo_save(db.mongo, list, "greendb", "navers")
# db.mongo_delete(db.mongo, {}, "greendb", "navers")

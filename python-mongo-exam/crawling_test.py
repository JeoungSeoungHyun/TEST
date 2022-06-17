import requests
from bs4 import BeautifulSoup

for number in range(1, 21):
    aid = format(number, '010')
    html = requests.get(
        f"https://n.news.naver.com/mnews/article/005/{aid}?sid=100")
    if(html.status_code == 200):
        # print(html.text)
        print(number)
        soup = BeautifulSoup(html.text, 'html.parser')
        try:
            title_el = soup.select_one(
                ".media_end_head_title  .media_end_head_headline")
            company_el = soup.select_one(
                ".media_end_head_top_channel_layer_text > strong")
            date_el = soup.select_one(
                ".media_end_head_info_datestamp_bunch > span")
            print(title_el.string.strip())
            print(company_el.string)
            print(date_el.string)
            print('='*40)
        except:
            title_el = soup.select_one(
                ".end_ct .end_tit")
            company_el = soup.select_one(
                ".end_ct .end_ct_area .press_logo > img")
            date_el = soup.select_one(
                ".end_ct .article_info > span > em")
            print(title_el.string.strip())
            print(company_el['alt'])
            print(date_el.string)
            print('='*40)

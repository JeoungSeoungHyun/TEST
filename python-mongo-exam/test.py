import requests
from bs4 import BeautifulSoup


html = requests.get(
    f"https://search.naver.com/search.naver?query=%ED%95%9C%EC%8B%9D%20%EB%A0%88%EC%8B%9C%ED%94%BC&nso=&where=view&sm=tab_nmr&mode=normal")


soup = BeautifulSoup(html.text, 'html.parser')

n = 0
active = 1
# 타이틀/url 찾기
while active:
    n = n+1
    print("="*60)
    try:
        result = soup.find(attrs={'data-cr-rank': f'{n}'}
                           ).find(class_={'api_txt_lines'})
        url = soup.find(attrs={'data-cr-rank': '1'}
                        ).find(class_={'thumb_single'})['href']
        imgUrl = soup.find(attrs={'data-cr-rank': '1'}
                           ).find(class_={'thumb_single'}).find('img')['src']
        print('제목 : ' + result.text)
        print('URL : ' + url)
        print('이미지 : ' + imgUrl)
    except:
        active = 0

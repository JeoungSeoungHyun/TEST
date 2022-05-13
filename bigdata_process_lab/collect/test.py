from bs4 import BeautifulSoup
import requests
from datetime import datetime

# 메서드가 아니기 때문에 self가 필요없음

# 내부 메서드는 private 하게 만들고 이것만 접근 가능하게 한다. => interface


def craw(num):

    # 파이프라인 방식 => 두번 호출을 해야한다. 호출하는데 번거로움
    aid = num_to_aid(num)
    result = naver_craw(aid)


def num_to_aid(num):
    num_str = str(num)
    return num_str.zfill(10)

# dependency -> num_to_aid(int:num)


def naver_craw(num):
    result = {"title": "", "company": "국민일보", "createdAt": datetime.now()}

    response = requests.get(
        f"https://entertain.naver.com/read?oid=005&aid={num_to_aid(num)}"
    )

    html = response.text

    html_bs = BeautifulSoup(html, "html.parser")

    title = html_bs.select(".end_tit")[0].get_text().strip()

    result["title"] = title
    # db에 밀어넣기 때문에 dict으로 리턴
    return result

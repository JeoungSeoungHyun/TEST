import db


def save(**data):
    print(data)
    # data의 변수 바인딩은 DICT에 있는 key와 같은 형태가 되야 하구나!!!!
    sql = "INSERT INTO air (msrdt,msrrgn_nm,msrste_nm,pm10,pm25,o3,no2,co,so2,idex_nm,idex_mvl,arplt_main) VALUES "
    sql += "(%(MSRDT)s,%(MSRRGN_NM)s,%(MSRSTE_NM)s,%(PM10)s,%(PM25)s,%(O3)s,%(NO2)s,%(CO)s,%(SO2)s,%(IDEX_NM)s,%(IDEX_MVL)s,%(ARPLT_MAIN)s)"
    try:
        db.cursor.execute(sql, data)
    except Exception as e:
        print(e)
        db.conn.rollback()
        return -1
    db.conn.commit()
    return 1

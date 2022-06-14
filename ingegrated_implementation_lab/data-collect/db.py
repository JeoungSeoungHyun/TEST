from pymysql import connect, cursors

conn = connect(
    host="localhost",
    user="green",
    passwd="green1234",
    db="greendb",
    charset="utf8"
)

cursor = conn.cursor(cursors.DictCursor)  # 기본이 tuple

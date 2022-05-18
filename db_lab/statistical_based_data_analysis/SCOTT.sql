SELECT * 
FROM 
cancer;

SELECT 암종류,발생자수
FROM cancer 
WHERE 발생자수 = 
(
    SELECT max(발생자수)
    FROM cancer
    WHERE NOT (암종류 LIKE '%모든암%' OR 암종류 LIKE '%기타암%')
);

SELECT *
FROM 
(
    SELECT rank() OVER(ORDER BY 발생자수 DESC) as rank,c.*
    FROM cancer c
    WHERE NOT (암종류 LIKE '%모든암%' OR 암종류 LIKE '%기타암%')
)
WHERE RANK <6;

SELECT *
FROM
(
    SELECT *
    FROM cancer c
    WHERE NOT (암종류 LIKE '%모든암%' OR 암종류 LIKE '%기타암%')
)
WHERE TO_NUMBER(분율)>=10;

SELECT 암종류,발생자수
FROM cancer
WHERE 암종류 LIKE '%백혈병%';
SELECT type as "암종",occur_count as "발생자수"
FROM cancer 
WHERE occur_count = 
(
    SELECT max(occur_count)
    FROM cancer
    WHERE NOT (TYPE LIKE '%모든암%' OR TYPE LIKE '%기타암%')
);

SELECT *
FROM 
(
    SELECT c.*, rank() OVER(ORDER BY occur_count DESC) as rank
    FROM cancer c
    WHERE NOT (TYPE LIKE '%모든암%' OR TYPE LIKE '%기타암%')
)
WHERE RANK <6;

SELECT *
FROM
(
    SELECT *
    FROM cancer c
    WHERE NOT (TYPE LIKE '%모든암%' OR TYPE LIKE '%기타암%')
)
WHERE TO_NUMBER(fraction)>=10;

SELECT type as "암종류",occur_count as "발생자 수"
FROM cancer
WHERE TYPE LIKE '%백혈병%';